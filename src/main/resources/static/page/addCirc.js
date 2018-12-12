layui.use(['layer','jquery','form'],function(){
   var layer = layui.layer
       ,$ = layui.jquery
       ,form = layui.form;
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
    function jisuan(pole){
        console.log(pole)
        var gl = parseInt(map.getDistance(pole[0],pole[1]).toFixed(3)/1000);
        $("input[name = arroundlength]").val(gl='公里');
    }

    //设置起始塔杆位置
    $("#StartpoleNo").click(function(){
        // $("#btn_end").attr("disabled", true);
        map.addEventListener("click", start_click);
    });
    var PoleList = [];//塔杆集合
    var startPole;
    function start_click(type) {
        console.log(type);
        console.log(type.overlay.z.title);
        $("input[name = poleByStartpoleNo]").val(type.overlay.z.title);
        var s1 = type.overlay.Iz.lng;
        var s2 = type.overlay.Iz.lat;
        console.log(s1,s2);
        PoleList.push(new BMap.Point(s1,s2));
        $("startPole").val(s1+','+s2);
        startPole = s1+','+s2;
        layer.msg( startPole);
        map.removeEventListener("click", start_click);
    }
    //设置终止塔杆位置
    var endPole;
    $("#EndpoleNo").click(function(){
        // $("#btn_end").attr("disabled", true);
        map.addEventListener("click", end_click);
    });
    function end_click(type) {
        console.log(type.overlay.z.title);
        $("input[name = poleByEndpoleNo]").val(type.overlay.z.title);
        var s1 = type.overlay.Iz.lng;
        var s2 = type.overlay.Iz.lat;
        PoleList.push(new BMap.Point(s1,s2));
        $("endPole").val(s1+','+s2);
        endPole = s1+','+s2;
        add_drawRouteLine(new Array());
    };
    //画线
    var polyline;
    function add_drawRouteLine(jihe){
        map.removeOverlay(polyline);
        var start = startPole.split(',');
        var kai = new BMap.Point(start[0],start[1]);
        start = endPole.split(',');
        var end = new BMap.Point(start[0],start[1]);
        var PoleList = new Array(jihe.length+2);
        PoleList[0] = kai;
        for (var i = 0; i < jihe.length; i++) {
            PoleList[i+1]=jihe[i];
        }
        PoleList[PoleList.length-1]=end;
        polyline = new BMap.Polyline(PoleList,{strokeColor:"red", strokeWeight:6, strokeOpacity:0.5});
        map.addOverlay(polyline);//添加路线
        map.removeEventListener("click", end_click);
        var gl = parseInt(map.getDistance(PoleList[0],PoleList[1]).toFixed(3)/1000);
        $("input[name = arroundlength]").val(gl+'公里');
    }

    $("#poleNoList").click(function(){
        var jihe = $("#poleNoList").val();
        if(jihe == '设置完毕'){
            map.removeEventListener("click", poleNoList_click);
            return;
        }
        map.addEventListener("click", poleNoList_click);
        $("#poleNoList").val('设置完毕');
    });
    var jihe = [];//塔杆集合
    function poleNoList_click(type){
        var s1 = type.overlay.Iz.lng;
        var s2 = type.overlay.Iz.lat;
        jihe.push(new BMap.Point(s1,s2));
        var title = $("input[name = jihe]").val()+ type.overlay.z.title+" ";
        $("input[name = jihe]").val(title);
        add_drawRouteLine(jihe);

    }

    form.on('submit(formDemo)',function(data){
        layer.msg(JSON.stringify(data.field));
        return false;
    });
});