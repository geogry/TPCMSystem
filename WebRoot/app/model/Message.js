//消息类
Ext.define("Message", {
	extend : 'Ext.data.Model',
	fields : [
		{name : 'id', type : 'string', sortable : true},
		{name : 'time', type : 'string', sortable : true},
		{name : 'content', type : 'string', sortable : true}
	]
});