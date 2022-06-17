/* 썸머노트 세팅 */
$(document).ready(function() {
    $('#summernote').summernote({
        width : 1040,
        height: 480,                 // set editor height
        focus: true,                  // set focus to editable area after initializing summernote
        lang: 'ko-KR', // default: 'en-US'
        placeholder : '스터디에 대해 소개해주세요!',
        toolbar: [
            ['fontname', ['fontname']],
            ['fontsize', ['fontsize']],
            ['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
            ['color', ['forecolor','color']],
            ['table', ['table']],
            ['para', ['ul', 'ol', 'paragraph']],
            ['height', ['height']],
            ['insert',['picture','link','video']],
          ],
        fontNames: ['맑은 고딕','궁서','굴림체','굴림','돋음체','바탕체','Arial', 'Arial Black', 'Comic Sans MS', 'Courier New'],
        fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72']
    });
    $('#summernote').summernote('fontSize', 16);
  });


/* select Box */
function toggleSelect(selectBox){
    selectBox.classList.toggle("active"); 
}

function selectOption(option){
    const selectBox = option.closest(".selectBox"); // 클릭한 옵션의 selectBox 찾기
    const selectVal = selectBox.querySelector(".selectedValue");   //클릭한 옵션이 들어갈 객체 (selected)
    selectVal.textContent = option.textContent; // 클릭한 option의 text로 변경해줌
}

const selectArr = document.querySelectorAll(".selectBox");

selectArr.forEach(select => {
    select.addEventListener("click", function(e){
        const target = e.target; // 클릭한 객체
        const option = target.classList.contains("option"); // 클릭한 객체가 option인지 확인

        if(option){ // 클릭한 객체가 옵션일 경우
            selectOption(target); 
            // selected 부분의 text을 해당 옵션으로 변경하는 function
        }
        
        toggleSelect(select); // 클릭시 옵션List 열고 닫아주기
    });
});

