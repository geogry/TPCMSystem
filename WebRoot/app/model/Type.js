//设备与耗材的类型
Ext.define("Type", {
	extend : 'Ext.data.Model',
	fields : [
		{name : 'id', type : 'string', sortable : true},
		{name : 'typename', type : 'string', sortable : true},
		{name : 'iselement', type : 'int', sortable : true}
	]
});