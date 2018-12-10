layui.use(['form','layer'],function(){
    var form = layui.form
    layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;

    form.on("submit(addUser)",function(data){
        //弹出loading
        var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
        $.post(ctx+"sys/user/save",{
            username : $(".userName").val(),  //登录名
            email : $(".userEmail").val(),  //邮箱
            sex : data.field.sex,  //性别
            rid : data.field.rid  //角色
        },function(r){
            top.layer.close(index);
            top.layer.msg(r.msg);
            if(r.code == 0){
                layer.closeAll("iframe");
                //刷新父页面
                parent.location.reload();
            }
        })
        return false;
    })

})