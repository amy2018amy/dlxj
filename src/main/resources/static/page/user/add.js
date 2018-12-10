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

    loadSelectData();
    //加载下拉框数据
    function loadSelectData(){
        $.post(ctx+"sys/role/selectData",{},function(re){
            $('.roleVal').empty();
            var result = eval(re);
            $('.roleVal').append(new Option('全部',''));
            $.each(result,function(i,n){
                $('.roleVal').append(new Option(n.name,n.id));//往下拉菜单里添加元素
            });
            form.render();//菜单渲染 把内容加载进去
        });
    }


})