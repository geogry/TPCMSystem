//器件耗材类,element会跟Ext中的名字冲突，所以命名为ElementX
Ext.define("ElementX", {
	extend : 'Ext.data.Model',
	fields : [
		{name : 'id', type : 'string', sortable : true},
		{name : 'elementname', type : 'string', sortable : true},
		{name : 'type.typename', type : 'string', sortable : true},
		{name : 'feature', type : 'string', sortable : true},
		{name : 'store', type : 'int', sortable : true},
		{name : 'locker.id', type : 'string', sortable : true},
		{name : 'locker.addr', type : 'string', sortable : true},
		{name : 'img', type : 'string', sortable : true},
		{name : 'manual', type : 'string', sortable : true}
	]
});