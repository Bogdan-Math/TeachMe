function show(language) {
    /*todo: fix switching language from different pages*/
    window.location.href = window.location.href.split('?')[0] + '?language=' + language;
}
