//临时申购信息
Ext.define("RefusePor", {
	extend : 'Ext.data.Model',
	fields : [
		{name : 'id', type : 'int', sortable : true},
		{name : 'applicant.id', type : 'string', sortable : true},
		{name : 'applicant.relname', type : 'string', sortable : true},
		{name : 'applicant.post.postname', type : 'string', sortable : true},
		{name : 'tempElement.id', type : 'int', sortable : true},
		{name : 'tempElement.elementname', type : 'string', sortable : true},
		{name : 'tempElement.feature', type : 'string', sortable : true},
		{name : 'tempElement.type.typename', type : 'string', sortable : true},
		{name : 'tempElement.count', type : 'string', sortable : true},
		{name : 'tempElement.price', type : 'int', sortable : true},
		{name : 'tempElement.img', type : 'int', sortable : true},
		{name : 'tempElement.manual', type : 'int', sortable : true},
		{name : 'verifier.relname', type : 'string', sortable : true},
		{name : 'time', type : 'string', sortable : true},
		{name : 'info', type : 'string', sortable : true}
	]
});