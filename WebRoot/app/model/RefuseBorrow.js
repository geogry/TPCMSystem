//已拒绝的申领信息
Ext.define("RefuseBorrow", {
	extend : 'Ext.data.Model',
	fields : [
		{name : 'id', type : 'int', sortable : true},
		{name : 'applicant.id', type : 'string', sortable : true},
		{name : 'applicant.relname', type : 'string', sortable : true},
		{name : 'applicant.post.postname', type : 'string', sortable : true},
		{name : 'element.id', type : 'string', sortable : true},
		{name : 'element.elementname', type : 'string', sortable : true},
		{name : 'element.type.typename', type : 'string', sortable : true},
		{name : 'element.feature', type : 'string', sortable : true},
		{name : 'element.locker.id', type : 'string', sortable : true},
		{name : 'element.locker.addr', type : 'string', sortable : true},
		{name : 'element.store', type : 'int', sortable : true},
		{name : 'element.img', type : 'string', sortable : true},
		{name : 'element.manual', type : 'string', sortable : true},
		{name : 'verifier.relname', type : 'string', sortable : true},
		{name : 'count', type : 'int', sortable : true},
		{name : 'time', type : 'string', sortable : true},
		{name : 'purpose', type : 'string', sortable : true}
	]
});