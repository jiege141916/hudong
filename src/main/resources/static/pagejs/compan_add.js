new Vue({
    el:'#div',
    data:{
        list:[],
        pageInfo:{}
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
        }

    },
    created(){
    }
});