layui.use(['layer','jquery','form','element'],function(){
    var layer = layui.layer
        ,$ = layui.jquery
        ,form = layui.form
        ,element = layui.element;
    var map = new BMap.Map("container");
    var point = new BMap.Point(116.404, 39.915);
    map.centerAndZoom(point,10);
    map.enableScrollWheelZoom();
//鼠标缩放
    map.enableKeyboard();
//    键盘平移
    map.enableContinuousZoom();
//    连续缩放效果
    map.enableInertialDragging();
//    惯性拖拽效果
    map.addControl(new BMap.NavigationControl());
//    平移缩放控件
    $.ajax({
        type: "POST",
        url: "/circ/allCirc",
        success: function (strData) {
            var data;
            if(typeof(strData) == "string"){
                data = JSON.parse(strData); //部分用户解析出来的是字符串，转换一下
            }else{
                data = strData;
            }
            console.log(data)
            var html = "";
            $(data.circ).each(function(i,n){
                // layer.msg(n.allPole[0].pole.id);
                html+="<option value="+n.id+">"+n.name+"</option>";
                var polyLen = [];
                for (var j=0;j<n.allPole.length;j++){
                    // console.log(n.allPole[2].pole.id);
                    var p1 = n.allPole[j].pole.lng;
                    var p2 = n.allPole[j].pole.lat;
                    polyLen.push(new BMap.Point(p1,p2));
                }
                var polyline = new BMap.Polyline(polyLen,{strokeColor:"red", strokeWeight:6, strokeOpacity:0.5,title :n.name});
                map.addOverlay(polyline);//添加路线
                polyline.addEventListener("mouseover",function(){
                    layer.msg(n.name);
                });
            });
            $("#selId").append(html);
            //重新渲染select
            form.render('select');
        }
    });
    form.on('submit(formDemo)',function(data){
        console.log(data.field);
        $.ajax({
            type: "POST",
            data: data.field,
            url: "/circ/delCirc",
            success: function (strData) {
                var data;
                if(typeof(strData) == "string"){
                    data = JSON.parse(strData); //部分用户解析出来的是字符串，转换一下
                }else{
                    data = strData;
                }
                if(data.code==500){
                    layer.msg('删除失败');
                }else {
                    layer.msg('删除成功');
                    window.sessionStorage.removeItem("menu");
                    window.sessionStorage.removeItem("curmenu");
                    location.reload();
                }
            }
        });
        return false;
    });
});