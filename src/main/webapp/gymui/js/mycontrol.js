function createFile(fid)
{
    var ctrl=$("<input/>").attr({type:'file',id:fid,name:fid,});
    return ctrl;
}
function createButton(fid)
{
    var ctrl=$("<input/>").attr({type:'button',id:fid,value:'remove'});
    return ctrl;
}
function createTextbox1(fid)
{
    var ctrl=$("<input/>").attr({
        type:'text',
        id:fid,
        placeholder:'Description',
        class: 'form-control' 
    });
    return ctrl;
}
function createDiv(fid)
{
    var ctrl=$("<div/>").attr({id:fid});
    return ctrl;
}


function createButton2(fid)
{
    var ctrl=$("<input/>").attr({type:'button',id:fid,value:'remove'});
    return ctrl;
}
function createTextarea2(fid)
{
    var ctrl=$("<input/>").attr({
        type:'textarea',
        id:fid,
        placeholder:'Achievement Description',
        class: 'form-control' 
    });
    return ctrl;
}
function createTextbox2(fid)
{
    var ctrl=$("<input/>").attr({
        type:'text',
        id:fid,
        placeholder:'Achievement Title',
        class: 'form-control' 
    });
    return ctrl;
}
function createDiv2(fid)
{
    var ctrl=$("<div/>").attr({id:fid});
    return ctrl;
}