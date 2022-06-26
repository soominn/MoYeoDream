$(document).ready(function() {
    $("div.study-registered-date").text(dateFormat(studyRegisterDate));
    $("span.study-start").text(dateFormat(studyStartDate));

    $("div.user-introduction").append(studyChief);
    $("div.study-introduction").append(studyContent);

    if(studyCategory == "culture") {
        $("span.study-cate").text("문화/예술");
    }
    else if(studyCategory == "sports") {
        $("span.study-cate").text("스포츠/레저");
    }
    else if(studyCategory == "computer") {
        $("span.study-cate").text("컴퓨터/프로그래밍");
    }
    else if(studyCategory == "language") {
        $("span.study-cate").text("외국어/토익/토플");
    }
    else if(studyCategory == "humanities") {
        $("span.study-cate").text("인문/과학");
    }
    else if(studyCategory == "economy") {
        $("span.study-cate").text("경제/금융");
    }
    else if(studyCategory == "politics") {
        $("span.study-cate").text("정치/사회");
    }
    else if(studyCategory == "certificate") {
        $("span.study-cate").text("자격증");
    }
    else if(studyCategory == "publicOfficial") {
        $("span.study-cate").text("공무원");
    }
    else if(studyCategory == "employment") {
        $("span.study-cate").text("취업/면접");
    }

    if(studyProcess == "online") {
        $("span.study-process").text("온라인");
    }
    else if(studyProcess == "offline") {
        $("span.study-process").text("오프라인");
    }

    if(studyPersonnel == "none") {
        $("span.study-people").text("인원 미정");
    }
    else if(studyPersonnel == "one") {
        $("span.study-people").text("1명");
    }
    else if(studyPersonnel == "two") {
        $("span.study-people").text("2명");
    }
    else if(studyPersonnel == "three") {
        $("span.study-people").text("3명");
    }
    else if(studyPersonnel == "four") {
        $("span.study-people").text("4명");
    }
    else if(studyPersonnel == "five") {
        $("span.study-people").text("5명");
    }
    else if(studyPersonnel == "six") {
        $("span.study-people").text("6명");
    }
    else if(studyPersonnel == "seven") {
        $("span.study-people").text("7명");
    }
    else if(studyPersonnel == "eight") {
        $("span.study-people").text("8명");
    }
    else if(studyPersonnel == "nine") {
        $("span.study-people").text("9명");
    }
    else if(studyPersonnel == "tenUp") {
        $("span.study-people").text("10명 이상");
    }

    if(studyPeriod == "none") {
        $("span.study-period").text("기간 미정");
    }
    else if(studyPeriod == "oneMonth") {
        $("span.study-period").text("1개월");
    }
    else if(studyPeriod == "twoMonths") {
        $("span.study-period").text("2개월");
    }
    else if(studyPeriod == "threeMonths") {
        $("span.study-period").text("3개월");
    }
    else if(studyPeriod == "fourMonths") {
        $("span.study-period").text("4개월");
    }
    else if(studyPeriod == "fiveMonths") {
        $("span.study-period").text("5개월");
    }
    else if(studyPeriod == "sixMonths") {
        $("span.study-period").text("6개월");
    }
    else if(studyPeriod == "longTerm") {
        $("span.study-period").text("장기");
    }
});

$("a.kakao-openchatting").click(function() {
    location.href = studyCommunication;
});

function dateFormat(format) {
    let date = new Date(format);
    return date.getFullYear() + "-" + ((date.getMonth() + 1) > 9 ? (date.getMonth() + 1).toString() : "0" + (date.getMonth() + 1)) + "-" + (date.getDate() > 9 ? date.getDate().toString() : "0" + date.getDate().toString());
}

function clickModify() {
    location.href = "/study/modify?studyNumber=" + studyNumber;
}

function clickRemove() {
    location.href = "/study/remove?studyNumber=" + studyNumber;
}