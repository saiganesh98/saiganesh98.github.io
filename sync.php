<?php
if (array_key_exists('HTTP_ORIGIN', $_SERVER)) {
    header('Access-Control-Allow-Origin: ' . $_SERVER["HTTP_ORIGIN"]);
} else {
    header('Access-Control-Allow-Origin:*');
}
header('Access-Control-Allow-Credentials:true');
foreach ($_COOKIE as $key => $value) {
    if (preg_match('/^(_vis_opt|_vwo)/', $key)) {
        // Expire any VWO cookies after 10 years.
        
        // Set the cookie on root path so that it's accessible on all paths
        
        // Set the domain to .eTld+1 e.g. for a.abc.com eTld would be abc.com. So domain should be .abc.com. If you are not sure about what is the value in your case, you can contact the VWO support team.
        setcookie($key, $value, time() + 3600 * 24 * 10 * 365, "/", ".github.io");
        // setcookie($key, $value, time() + 3600 * 24 * 10 * 365, "/", ".abc.com");
    }
}
echo 1; // success
?>