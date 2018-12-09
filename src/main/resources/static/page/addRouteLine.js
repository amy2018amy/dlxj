layui.use(['jquery','layer'],function(){
    var $ = layui.jquery,
        layer = layui.layer;
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
        url: "/route/allRoute",
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
               addRight(marker);
            });
            // console.log(data.code);
            // console.log(data);
        }
    });
    function addRight(marker){
        //添加右键菜单
        var menu = new BMap.ContextMenu();

        var txtMenuItem=[
            {
                text:"删除",
                callback:function(){
                    $.ajax({
                        type: "POST",
                        url: "/route/delPole",
                        data:{'id':marker.getTitle()},
                        success: function (strData) {
                            var data;
                            if(typeof(strData) == "string"){
                                data = JSON.parse(strData); //部分用户解析出来的是字符串，转换一下
                            }else{
                                data = strData;
                            }
                            console.log(data.code);
                            console.log(data);
                            if(data.code==200){
                                map.removeOverlay(marker);
                            }else{
                                layer.msg('塔杆已加入路线，请先删除路线');
                                return false;
                            }
                        }
                    });

                }
            }
        ];
        for(var i = 0;i<txtMenuItem.length;i++){
            menu.addItem(new BMap.MenuItem(txtMenuItem[i].text,txtMenuItem[i].callback,100));
        }
        marker.addContextMenu(menu);
    }
    //    动态添加坐标
    map.addEventListener("click",addDian);
    //点击添加塔杆
    function addDian(e){
        var title = prompt("请输入坐标名称");
        // var title = layer.confirm('请输入坐标名');
        if(title!=null &&title!=''){
            var zuobiao = new BMap.Point(e.point.lng, e.point.lat);
            // var myIcon = new BMap.Icon("res/images/timg.png",new BMap.Size(16,16));
            var marker = new BMap.Marker(zuobiao,{title:title});
            $.ajax({
                type: "POST",
                url: "/route/addPole",
                data:{'title':title,'lng':e.point.lng,'lat':e.point.lat},
                success: function (strData) {
                    var data;
                    if(typeof(strData) == "string"){
                        data = JSON.parse(strData); //部分用户解析出来的是字符串，转换一下
                    }else{
                        data = strData;
                    }
                    console.log(data.code);
                    console.log(data);
                    if(data.code==200){
                        map.addOverlay(marker);
                        addRight(marker);
                    }else{
                        layer.msg('塔杆编号已存在');
                        return false;
                    }
                }
            });
        }else{
            return false;
        }
    }
});