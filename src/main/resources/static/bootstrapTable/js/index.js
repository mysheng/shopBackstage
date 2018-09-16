/**
 * Created by mysheng on 2016/6/8.
 */
$(function () {
    var panelBody = $(window).height();
    console.log(panelBody)
   $("#panel-body").height(panelBody-16);
    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();

    //2.初始化Button的点击事件
    var oButtonInit = new ButtonInit();
    oButtonInit.Init();
    //3.上传图片控件初始化
     var oFileInput = new FileInput();
    oFileInput.Init("file", "/office/uploadimg");


});
var FileInput = function () {
    var oFile = new Object();

    //初始化fileinput控件（第一次初始化）
    oFile.Init = function(ctrlName, uploadUrl) {
        var control = $('#' + ctrlName);

        //初始化上传控件的样式
        control.fileinput({
            language: 'zh', //设置语言
            uploadUrl: uploadUrl, //上传的地址
            allowedFileExtensions: ['jpg', 'gif', 'png'],//接收的文件后缀
            showUpload: true, //是否显示上传按钮
            showCaption: false,//是否显示标题
            browseClass: "btn btn-primary", //按钮样式
            //dropZoneEnabled: false,//是否显示拖拽区域
            //minImageWidth: 50, //图片的最小宽度
            //minImageHeight: 50,//图片的最小高度
            //maxImageWidth: 1000,//图片的最大宽度
            //maxImageHeight: 1000,//图片的最大高度
            //maxFileSize: 0,//单位为kb，如果为0表示不限制文件大小
            minFileCount: 1,
            maxFileCount: 5, //表示允许同时上传的最大文件个数

            enctype: 'multipart/form-data',
            validateInitialCount:true,
            previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
            msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
            uploadExtraData: function(previewId, index) {   //额外参数的关键点
                var obj = {};
                obj.goodsId = $("#goodsIdImg").val();
                console.log(obj);
                return obj;
            }
            });

        //导入文件上传完成之后的事件
        $("#file").on("fileuploaded", function (event, data, previewId, index) {
            console.log(data);
            var code = data.response.code;
            if (code == 0) {
                console.log(data)
                return;
            }
            //1.初始化表格
            var oTable = new TableInit();
            oTable.Init(data);
            //$("#div_startimport").show();
        });
    }
    return oFile;
};

var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#tb_departments').bootstrapTable({
            url: '/office/goods/findGoods',         //请求后台的URL（*）
            method: 'post',                      //请求方式（*）
            toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: true,                     //是否启用排序
            sortOrder: "desc",                   //排序方式
            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 20, 30, 35],        //可供选择的每页的行数（*）
            search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: true,
            contentType: "application/json;charset=UTF-8",
            showPaginationSwitch:true,
            showColumns: true,                  //是否显示所有的列
            showRefresh: true,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
            height: 530,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "goodsId",                     //每一行的唯一标识，一般为主键列
            showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子
            showExport: true,                     //是否显示导出
            exportDataType: "all",              //basic', 'all', 'selected'.
            responseHandler :oTableInit.responseHandler,
            rowStyle:oTableInit.rowStyle,
            onEditableSave:oTableInit.onEditableSave,
            columns: [{
                checkbox: true
            },{
                field: 'goodsId',
                title: '商品ID', sortable: true,align:'center',visible:false,
                editable:false
            }, {
                field: 'goodsName',
                title: '商品名称',align:'center',
                editable:false
            }, {
                field: 'goodsNum',
                title: '商品编码',align:'center',visible:false,
                editable:false
            }, {
                field: 'goodsType',
                title: '商品类型',align:'center',
                editable:true
            },{
                field: 'oldPrice',
                title: '原价', sortable: true,align:'center',
                editable:true
            }, {
                field: 'price',
                title: '现价', sortable: true,align:'center',
                editable:true
            },{
                field: 'repertory',
                title: '库存', sortable: true,align:'center',
                editable:true
            }, {
                field: 'createDate',
                title: '创建时间', sortable: true,align:'center',
                editable:false
            }, {
                field: 'updateDate',
                title: '修改时间', sortable: true,align:'center',
                editable:false
            }]
        });
    };
    oTableInit.onEditableSave=function (field, row, oldValue, $el) {
        console.log(row);
        $.ajax({
            type: "post",
            url: "/office/goods/update",
            data: JSON.stringify(row),
            contentType:'application/json;charset=UTF-8',
            success: function (data, status) {
                if (status == "success") {
                    alert("编辑成功");
                }
            },
            error: function () {
                alert("Error");
            },
            complete: function () {

            }

        });
    }
    //得到查询的参数
   oTableInit.responseHandler = function (res) {
        res=res.data;
        if(res==null){
            res=[]
        }
        return res;
    };
    //数据加载前处理
    oTableInit.queryParams = function (params) {
        var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            // limit: params.limit,   //页面大小
            // offset: params.offset,  //页码
            goodsName: $("#goodsNames").val(),
            goodsType: $("#goodsTypes").val()
        };
        return JSON.stringify(temp);
    };
    oTableInit.rowStyle = function rowStyle( row, index) {

        var strclass = "";
        if (row.repertory<10) {
            strclass = 'danger';
        }else {
            return {};
        }
    // else if (row.repertory >10) {
    //         strclass = 'active';
    //     }else if (index%5 == 2) {
    //         strclass = 'info';
    //     }else if (index%5 == 3) {
    //         strclass = 'warning';
    //     }else if (index%5 == 4) {
    //         strclass = 'success';
    //     }
        return { classes: strclass }

    }

    return oTableInit;
};

/*绑定按钮数据初始化*/
var ButtonInit = function () {
    var oInit = new Object();
    var postdata = {};

    oInit.Init = function () {
        //$("#btn_query").bind("click", TableInit());


        var $table = $('#tb_departments'),
            $btn_add=$('#btn_add'),
            $btn_edit = $('#btn_edit'),
            $uploadImg = $('#uploadImg'),
            $button = $('#btn_delete');
            $("#btn_query").click(function () {
                $table.bootstrapTable('refresh', {url: '/office/goods/findGoods'});
            });
            $uploadImg.click(function () {
                var data= $table.bootstrapTable('getSelections');
                if(data.length==1){
                   var goodsId=data[0].goodsId;
                   $("#goodsIdImg").val(goodsId);
                   $("#imageUpload").toggle();
                }else if(data.length>1){
                    alert("暂不支持批量修改！")
                }else{
                    alert("请选择修改对象！")
                }
            })
            $button.click(function () {
                var JsonData = $table.bootstrapTable('getSelections');
                if (JsonData.length > 0) {
                    var ids = $.map(JsonData, function (data,a) {
                        console.log(data)
                        return data.goodsId;
                    });
                    $.ajax({
                        type: "get", //提交方式
                        url: "/office/goods/delete?id=" + ids,//路径
                        dataType: "json",
                        contentType: 'application/json;charset=UTF-8',
                        success: function (res) {//返回数据根据结果进行相应的处理
                            if (res.code == 1) {
                                $table.bootstrapTable('refresh', {url: '/office/goods/findGoods'});
                                // $table.bootstrapTable('remove', {
                                //     field: 'goodsId',
                                //     values: ids
                                // });
                            }
                        }
                    });



                } else {
                    alert("请选择要删除的对象！")
                }

            })
        $btn_add.click(function(){
              //  $table.bootstrapTable('refresh', {url: 'js/response.json'});
            add()
        });
        $btn_edit.click(function(){
           var data= $table.bootstrapTable('getSelections');
            if(data.length==1){
                update();
                $("#goodsId").val(data[0].goodsId);
                $("#goodsName").val(data[0].goodsName);
                $("#goodsType").val(data[0].goodsType);
                $("#oldPrice").val(data[0].oldPrice);
                $("#price").val(data[0].price);
                $("#goodsDescribe").val(data[0].goodsDescribe);
                $("#repertory").val(data[0].repertory);
            }else if(data.length>1){
                alert("暂不支持批量修改！")
            }else{
                alert("请选择修改对象！")
            }

        });


    };

    return oInit;
};
function updateAction(){
    var table = $('#tb_departments');
    var dataJson={
        goodsId:$("#goodsId").val(),
        goodsName:$("#goodsName").val(),
        goodsDescribe:$("#goodsDescribe").val(),
        oldPrice:$("#oldPrice").val(),
        price:$("#price").val(),
        goodsType:$("#goodsType").val(),
        repertory:$("#repertory").val()
    }
    $.ajax({
        type : "post", //提交方式
        url : "/office/goods/update",//路径
        data : JSON.stringify(dataJson),
        dataType:"json",
        contentType:'application/json;charset=UTF-8',
        success : function(res) {//返回数据根据结果进行相应的处理
            if(res.code==1){
                table.bootstrapTable('refresh', {url: '/office/goods/findGoods'});
                // $table.bootstrapTable('updateByUniqueId', {
                //     goodsId: $("#goodsId").val(),
                //     data: {
                //         goodsName:$("#goodsName").val(),
                //         goodsDescribe:$("#goodsDescribe").val(),
                //         oldPrice:$("#oldPrice").val(),
                //         price:$("#price").val(),
                //         goodsType:$("#goodsType").val(),
                //         repertory:$("#repertory").val()
                //     }
                //
                // });
            }
        }
    });

}
function addAction(){
    var table = $('#tb_departments');
    if($("#goodsId").val()==""){
        var dataJson={
            goodsName:$("#goodsName").val(),
            goodsDescribe:$("#goodsDescribe").val(),
            oldPrice:$("#oldPrice").val(),
            price:$("#price").val(),
            goodsType:$("#goodsType").val(),
            repertory:$("#repertory").val()
        }

        $.ajax({
            type : "post", //提交方式
            url : "/office/goods/addGoods",//路径
            data : JSON.stringify(dataJson),
            dataType:"json",
            contentType:'application/json;charset=UTF-8',
            success : function(res) {//返回数据根据结果进行相应的处理
                if(res.code==1){
                    $('#formAdd')[0].reset();;
                    table.bootstrapTable('refresh', {url: '/office/goods/findGoods'});
                }
            }
        });
    }else{
        updateAction();
    }


}
function add(){

    $("#addGoods").modal({
        keyboard:true
    });
}
function update(){

    $("#addGoods").modal({
        keyboard:true
    });
}