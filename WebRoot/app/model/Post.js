//职务数据类
Ext.define('Post', {
	extend : 'Ext.data.Model',
	fields : [
		{name : 'id', type : 'int', sortable : true},
		{name : 'postname', type : 'string', sortable : true}
	]
});