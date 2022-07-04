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
            // onImageUpload: function (fileList, editor, welEditable) {
            //     for(let i = 0; i < fileList.length; i++){
            //         sendFile(fileList[i]);
            //         // sendFile(fileList[i], $('#summernote'), '/board/boardWrite.html');
            //     }
            // }
            onImageUpload: function(files){
                sendFile(files, $('#summernote'), '/board/boardWrite.html');
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

// sendFile(file, el, uploadURL)
function sendFile(fileList, el, uploadURL){
    let formData = new FormData;
    // formData.append("file",file);

    let files = fileList;

    for(let i = 0; i < files.length; i++){
        formData.append("files", files[i]);
        console.log(files[i]);
        console.log(formData);
    }

    $.ajax({
        url : "/file/uploadPostFile",
        type : "post",
        data : formData,
        contentType : false,
        processData : false,
        enctype : 'multipart/form-data',
        success : function(fileList){
            console.log("업로드 성공");
            // location.href= '/upload/displayPostFile?path=2022/07/04/c5fff81b-8089-4c70-9c74-50cc3ced5c31_09.jpg';
           showUploadFiles(fileList, el);
        }
    })
}

function showUploadFiles(fileList,el) {
    let str = "";
    $.each(fileList,function(i, file){
        str += "<img src='/upload/displayPostFile?path="+ file.uploadDirectory + "/t_" + file.fileName + "'/>";
    })
    $(el).summernote('editor.insertImage', str);
}