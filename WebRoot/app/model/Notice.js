//公告
Ext.define("Notice", {
	extend : 'Ext.data.Model',
	fields : [
		{name:'id', type:'string', sortable:true},
		{name:'content', type:'string', sortable:true},
		{name:'time', type:'string', sortable:true}
	]
});