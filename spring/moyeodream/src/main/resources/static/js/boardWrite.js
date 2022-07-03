$(document).ready(function () {

    let toolbar = [
        // 글꼴 설정
        ['fontname', ['fontname']],
        // 글자 크기 설정
        ['fontsize', ['fontsize']],
        // 굵기, 기울임꼴, 밑줄,취소 선, 서식지우기
        ['style', ['bold', 'italic', 'underline', 'strikethrough', 'clear']],
        // 글자색
        ['color', ['forecolor', 'color']],
        // 표만들기
        ['table', ['table']],
        // 글머리 기호, 번호매기기, 문단정렬
        ['para', ['ul', 'ol', 'paragraph']],
        // 줄간격
        ['height', ['height']],
        // 그림첨부, 링크만들기, 동영상첨부
        ['insert', ['picture', 'link', 'video']],
        // 코드보기, 확대해서보기, 도움말
        ['view', ['codeview', 'fullscreen', 'help']]
    ];

    let setting = {
        height: 523,
        maxHeight: 523,
        minHeight: 523,
        lang: "ko-KR",
        placeholder: '내용을 작성해 주세요!',
        callbacks: {
            onImageUpload: function (files, editor, welEditable) {
                // 들어온 파일 한개씩 반복
                for (var i = files.length - 1; i >= 0; i--) {
                    sendFile(files[i], this);
                }

            }
        }
    };

    $('#summernote').summernote(setting);
// });

      console.log($(location).attr("pathname"));

      if($(location).attr("pathname") == "/post/modify"){
          // 값 들어왔는지 확인
          console.log(content);
          // 썸머노트에 값 불러오기
          $("#summernote").summernote('code',content);
      }

      let $registerBtn = $(".write_register");

      // 저장버튼 클릭
      $registerBtn.on("click",function(){
            saveContent();
          }
      )
});

function sendFile(files, el){
    let formData = new FormData;
    formData.append("file",files);

    for (var i = files.length - 1; i >= 0; i--) {
        sendFile(files[i], this);
    }

    $.ajax({
        url : "/file/uploadPostFile",
        type : "post",
        data : formData,
        contentType : false,
        processData : false,
        enctype : 'multipard/form-data',
        success : function(fileList){
            $(el).summernote('editor.insertImage', formData.url);
            console.log($(el).summernote('editor.insertImage', formData.url));
        }
    })
}
