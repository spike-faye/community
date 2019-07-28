/**
 * 提交回复
 */
function post() {
    var questionId= $("#question_id").val();
    var content = $("#comment_content").val();
    comment2target(questionId,1,content);
}

function comment2target(targetId,type,content) {
    if (!content){
        alert("不能回复空内容");
        return;
    }

    $.ajax({
        type: "POST",
        url: "/comment",
        contentType:"application/json",
        //我们可以使用 JSON.stringify() 方法将 JavaScript 对象转换为字符串
        data: JSON.stringify({
            "parentId":targetId,
            "content":content,
            "type":type
        }),
        success: function (response) {
            if (response.code == 200){
                window.location.reload();
            }else {
                if (response.code == 2003){
                    var isAccepted = confirm(response.message);
                    if(isAccepted){
                        window.open("https://github.com/login/oauth/authorize?client_id=7824dab5040d3c26f282&redirect_uri=http://localhost:8887/callback&scope=user&state=1");
                        debugger;
                        window.localStorage.setItem("closable",true);
                    }
                }else{
                    alert(response.message);
                }
            }
        },
        dataType: "json"
    });
}

function comment(e) {
    var commentId = e.getAttribute("data-id");
    console.log(commentId);
    var content = $("#input-"+commentId).val();
    console.log(content);
    comment2target(commentId,2,content);
}

/**
 * 展开二级评论
 */
function collapseComments(e) {
    var id = e.getAttribute("data-id");
    var comments = $("#comment-"+id);

    //获取一下二级评论的展开状态
    var collapse = e.getAttribute("data-collapse");
    if (collapse){
        //折叠二级评论
        comments.removeClass("in");
        e.removeAttribute("data-collapse");
        e.classList.remove("active");
    }else {
        $.getJSON("/comment/" + id,function (data) {
            console.log(data);
            var commentBody = $("comment-body-"+id);
            var items = [];
            $.each( data.data, function(comment) {
                var c = $("<div>",{
                    "class":"col-lg-12 col-md-12 col-sm-12 col-xs-12 collapse sub-comments",
                    html: comment.content
                });
                items.push(c);
            });

            commentBody.append($("<div>",{
                "class":"col-lg-12 col-md-12 col-sm-12 col-xs-12 collapse sub-comments",
                "id":"comment-"+id,
                html: items.join("")
            }));



            //展开二级评论
            comments.addClass("in");
            //标记二级评论展开状态
            e.setAttribute("data-collapse","in");
            e.classList.add("active");
        });
    }
}