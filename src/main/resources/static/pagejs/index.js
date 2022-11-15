new Vue({
    el:'#indexdiv',
    data:{
        man:{username:'',password:''}
    },
    methods:{
        getLogin:function () {
            var _this = this;
            axios.post('../man/getLogin',_this.user).then(function (response) {
                if(response.data.flag){
                    location.href = "../main/toList";
                }else {
                    alert(response.data.msg);
                }
            });
        }
    }
});