new Vue({
    el:'#div',
    data:{
        list:[],
        pageInfo:{},
        pageNum:1,
        pageSize:5,
        id:[],
    },
    methods:{

        saveGoods:function(){
            var _this = this;
            axios.post('../man/saveOrUpdate',_this).then(function (response) {
                if(response.data.flag){
                    _this.findAll();
                    document.getElementById("div").style.display="none";
                }else {
                    alert(response.data.msg);
                }
            });
        },
        toAddGoods:function(){
            document.getElementById("div").style.display="block";

        },

        deleteById:function(id){
            this.id.push(id);
            this.deleteBatch();
        },
        deleteBatch:function(){
            if(this.id!=null&&this.id.length>=1){
                var _this = this;
                axios.post('../man/deleteBatch',_this.id).then(function (response) {
                    if(response.data.flag){
                        _this.findAll();
                    }else {
                        alert(response.data.msg);
                    }
                });
            }
        },

        paging:function(pageNum){
            if(pageNum==0){
                pageNum = 1;
            }
            this.pageNum = pageNum;
            this.findAllConnAndPage();
        },
        findAllConnAndPage:function(){
            var _this = this;
            var url = '../man/findAllConnAndPage?pageNum='+this.pageNum+"&pageSize="+this.pageSize;
            axios.post(url).then(function (response) {
                _this.list = response.data.list;
                _this.pageNum = response.data.pageNum;
                _this.pageSize = response.data.pageSize;
                _this.pageInfo = response.data;
            });
        },
        findAll:function () {
            var _this = this;
            axios.get('../man/findAll').then(function (response) {
                _this.list = response.data;
            });
        },

    },

    created(){
        this.findAll();
    }
});