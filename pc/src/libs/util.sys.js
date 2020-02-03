const sys = {}

sys.options = function(value) {
    if(value == undefined) {
        return
    }
    let res = [];
    for(let item of value) {
        let opt = {
            label: item.value,
            value: item.code,
            children: this.options(item.children)
        }
        res.push(opt)
    }
    return res
}

sys.menuParse = function(value) {
    if(value == undefined || value.children == undefined) {
        return;
    }
    let res = []
    for (let item of value.children) {
        let opt = {
            path: item.url,
            title: item.name,
            icon: item.icon,
            children: this.menuParse(item)
        }
        res.push(opt)
    }
    return res;
}
export default sys