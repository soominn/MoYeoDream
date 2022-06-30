
let postCommentService = (function(){

    // 댓글 목록 불러오기
    function getList(postNumber, callback){
        $.getJSON("/postReply/list/"+ postNumber, function(list){
            if(callback){
                callback(list);
            }
        });
    }

    // 댓글 등록
    function register(param, callback){
        console.log("js : register.....");
        $.ajax({
            url : "/postReply/register",
            type : "post",
            data : JSON.stringify(param),
            contentType: "application/json",
            success : function(){
                if(callback){
                    console.log("댓글 등록 성공");
                    callback();
                }
            }
        });
    }

    // 댓글 수정
    function modify(param, callback){
        console.log("js.modify,....");
        $.ajax({
            url : "/postReply/modify",
            type : "post",
            data : JSON.stringify(param),
            contentType : "application/json",
            success : function(comment){
                if(callback){
                    callback(comment);
                };
            }
        });
    }

return {getList: getList, register: register, modify: modify};
})();