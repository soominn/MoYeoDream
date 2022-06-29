
let postCommentService = (function(){

    // 댓글 불러오기
    function getList(postNumber, callback){
        console.log("getList.....................");
        $.getJSON("/postReply/list/"+ postNumber, function(list){
            console.log("js : "+ list);
            if(callback){
                callback(list);
            }
        });
    }

return {getList:getList};
})();