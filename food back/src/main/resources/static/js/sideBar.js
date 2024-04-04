// 사이드바 토글
type = "text/javascript" >
    $(document).ready(function () {
        $(".navSide ul.sub").hide();
        $(".navSide ul.sideBar-toggle li").click(function () {
            $("ul", this).slideToggle("normal");
        });
    });

