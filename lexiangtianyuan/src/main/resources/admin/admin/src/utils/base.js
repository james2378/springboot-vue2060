const base = {
    get() {
        return {
            url : "http://localhost:8080/lexiangtianyuan/",
            name: "lexiangtianyuan",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/lexiangtianyuan/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "乐享田园系统"
        } 
    }
}
export default base
