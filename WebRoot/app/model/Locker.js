//仓库
Ext.define("Locker", {
	extend : 'Ext.data.Model',
	fields : [
		{name : 'id', type : 'string', sortable : true},
		{name : 'addr', type : 'string', sortable : true},
		{name : 'capacity', type : 'int', sortable : true},
		{name : 'nowcapacity', type : 'int', sortable : true}
	]
});