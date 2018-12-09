layui.use(['layer','jquery'],function(){
   var layer = layui.layer
       ,$ = layui.jquery;
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
        url: "/circ/allCircuitry",
        success: function (strData) {
            var data;
            if(typeof(strData) == "string"){
                data = JSON.parse(strData); //部分用户解析出来的是字符串，转换一下
            }else{
                data = strData;
            }
            $(data.pole).each(function(i,n){
                var point =new BMap.Point(n.lng,n.lat);
                // console.log(n.lng,n.lat);
                var myIcon = new BMap.Icon("/images/timg.png",new BMap.Size(16,16));
                var marker =new BMap.Marker( point,{title:n.id}); // 创建点
                map.addOverlay(marker);    //增加点
                //添加右键菜单
                // addRight(marker);
            });
                console.log(data)
            $(data.circ).each(function(i,n){
                // layer.msg(n.allPole[0].pole.id);
                var polyLen = [];
                for (var j=0;j<n.allPole.length;j++){
                    // console.log(n.allPole[2].pole.id);
                        var p1 = n.allPole[j].pole.lng;
                        var p2 = n.allPole[j].pole.lat;
                        polyLen.push(new BMap.Point(p1,p2));
                }
                var s1 =new BMap.Point(n.allPole[0].pole.lng,n.allPole[0].pole.lat);
                var s2 =new BMap.Point(n.allPole[1].pole.lng,n.allPole[1].pole.lat);
                var gl = parseInt(map.getDistance(s1,s2).toFixed(2)/1000);
                console.log(gl+' 公里。');
                // $(n.allPole).each(function(s,p){
                //     var p1 = p.pole.lng;
                //     var p2 = p.pole.lat;
                //     polyLen.push(new BMap.Point(p1,p2));
                // }
                var polyline = new BMap.Polyline(polyLen,{strokeColor:"red", strokeWeight:6, strokeOpacity:0.5,title :n.name});
                map.addOverlay(polyline);//添加路线
                polyline.addEventListener("mouseover",function(){
                   layer.msg(n.name);
                });
                //添加右键菜单
                // addRight(marker);
            })
            // console.log(data.code);
            // console.log(data);
        }
    });
});