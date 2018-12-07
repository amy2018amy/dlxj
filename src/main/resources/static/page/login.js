layui.use(['form','layer','jquery'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer
        $ = layui.jquery;

    // 链接
    $(".loginBody .seraph").click(function(){
        layer.msg($(this).attr("href"),{
            time:5000
        });
    })
    //登录按钮
    form.on("submit(login)",function(data){
        var btn = $(this);
        btn.text("登录中...").attr("disabled","disabled").addClass("layui-disabled");
        var index=null;
        $.ajax({
            type: "POST",
            url: ctx+"login",
            data: $('#signupForm').serialize(),
            beforeSend: function(){
                index = layer.load(1, {
                    shade: [0.1, '#fff'] //0.1透明度的白色背景
                });
            },
            success: function (r) {
                layer.close(index);
                if (r.code == 0) {
                    window.location.href = ctx+"main";
                } else {
                    layer.msg(r.msg);
                    $("#checkCodeImg").click();
                    btn.text("登录").removeAttr("disabled").removeClass("layui-disabled");
                }
            }
        });

        return false;
    })

    // 切换验证码
    $("#checkCodeImg").on('click',function(){
        var t = Math.random();
        $("#code").val("");
        $(this)[0].src=ctx+"genCaptcha?t="+t;
    });

    // 表单输入效果
    $(".loginBody .input-item").click(function(e){
        e.stopPropagation();
        $(this).addClass("layui-input-focus").find(".layui-input").focus();
    })
    $(".loginBody .layui-form-item .layui-input").focus(function(){
        $(this).parent().addClass("layui-input-focus");
    })
    $(".loginBody .layui-form-item .layui-input").blur(function(){
        $(this).parent().removeClass("layui-input-focus");
        if($(this).val() != ''){
            $(this).parent().addClass("layui-input-active");
        }else{
            $(this).parent().removeClass("layui-input-active");
        }
    })
})
