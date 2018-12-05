function hello(fid)
{
    var ctrl=fid;
    return ctrl;
}
function createButton(fid)
{
    var ctrl=$("<input/>").attr({type:'button',id:fid,value:'remove'});
    return ctrl;
}
function createTextbox1(fid)
{
    var ctrl=$("<input/>").attr({type:'textarea',id:fid,placeholder:'Description'});
    return ctrl;
}
function createDiv(fid)
{
    var ctrl=$("<div/>").attr({id:fid});
    return ctrl;
}