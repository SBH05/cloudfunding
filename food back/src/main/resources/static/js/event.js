window.onload = function() {

    /* 화면에 랜더링 된 태그들이 존재하지 않는 경우 에러 발생 가능성이 있어서 if문으로 태그가 존재하는지 부터 확인하고 이벤트를 연결한다. */
    if(document.getElementById("join")) {
        const $join = document.getElementById("join");
        $join.onclick = function() {
            location.href = "/member/join";
        }
    }


    if(document.getElementById("duplicationCheck")) {

        const $duplication = document.getElementById("duplicationCheck");

        /* fetch API 사용 */
        // $duplication.onclick = function() {
        //     let userId = document.getElementById("userId").value.trim();
        //
        //     fetch("/member/idDupCheck", {
        //         method: "POST",
        //         headers: {
        //             'Content-Type': 'application/json;charset=UTF-8'
        //         },
        //         body: JSON.stringify({userId: userId})
        //     })
        //         .then(result => result.text())
        //         .then(result => alert(result))
        //         .catch((error) => error.text().then((res) => alert(res)));
        //
        // }

        /* Jquery ajax 사용 */
        $('#duplicationCheck').click(function() {

            let userId = $("#userId").val().trim();

            $.ajax({
                url: "/member/idDupCheck",
                type: "POST",
                contentType: "application/json; charset=UTF-8",
                data: JSON.stringify({userId: userId}),
                success: function(data){
                    alert(data);
                },
                error: function(error) {
                    alert(error);
                }
            });
        });
    }
}