package io.autoconnector.engine.scan;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Builds an ordered list of fetch URLs to try for a given source URL — the
 * original first, then known mirrors / anonymisers, then the Wayback Machine
 * as a universal last-resort fallback.
 *
 * <p>The mirrors that matter most in practice are the GitHub ones, since the
 * direct raw.githubusercontent.com host is frequently blocked from Russia.
 */
public final class Mirrors {

    /** New-style GitHub raw URL: {@code .../refs/heads/<branch>/<path>}. */
    private static final Pattern GH_RAW_REFS = Pattern.compile(
            "https?://raw\\.githubusercontent\\.com/([^/]+)/([^/]+)/refs/heads/([^/]+)/(.+)");
    /** Classic GitHub raw URL: {@code .../<branch>/<path>}. */
    private static final Pattern GH_RAW = Pattern.compile(
            "https?://raw\\.githubusercontent\\.com/([^/]+)/([^/]+)/([^/]+)/(.+)");
    private static final Pattern GH_BLOB = Pattern.compile(
            "https?://github\\.com/([^/]+)/([^/]+)/(?:raw|blob)/([^/]+)/(.+)");

    /**
     * Returns the URL to try first plus zero or more fallbacks. The caller
     * iterates them in order and uses the first one that fetches successfully.
     */
    public static List<String> alternatives(String url) {
        List<String> out = new ArrayList<>();
        out.add(url);

        Matcher m = GH_RAW_REFS.matcher(url);
        if (!m.matches()) m = GH_RAW.matcher(url);
        if (!m.matches()) m = GH_BLOB.matcher(url);
        if (m.matches()) {
            String user = m.group(1);
            String repo = m.group(2);
            String branch = m.group(3);
            String path = m.group(4);
            addGithubMirrors(out, user, repo, branch, path);
        }

        // Universal fallback — Wayback usually has a recent snapshot of any
        // publicly reachable URL and is rarely blocked.
        out.add("https://web.archive.org/web/" + url);
        return out;
    }

    private static void addGithubMirrors(List<String> out,
                                         String user, String repo,
                                         String branch, String path) {
        // jsDelivr — globally cached CDN serving GitHub repos directly.
        out.add("https://cdn.jsdelivr.net/gh/" + user + "/" + repo
                + "@" + branch + "/" + path);
        // kkgithub.com — well-known GitHub mirror.
        out.add("https://raw.kkgithub.com/" + user + "/" + repo
                + "/" + branch + "/" + path);
        // ghproxy.com — HTTP reverse-proxy for GitHub raw content.
        out.add("https://ghproxy.com/https://raw.githubusercontent.com/"
                + user + "/" + repo + "/" + branch + "/" + path);
    }

    private Mirrors() {}
}
