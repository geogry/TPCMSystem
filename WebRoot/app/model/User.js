//User类
Ext.define("User", {
	extend : 'Ext.data.Model',
	fields : [
  		{name:'id', type:'string', sortable:true},
  		{name:'username', type:'string', sortable:true},
  		{name:'relname', type:'string', sortable:true},
  		{name:'password', type:'string', sortable:true},
  		{name:'post.id', type:'int', sortable:true},
  		{name:'post.postname', type:'string', sortable:true},
  		{name:'email', type:'string', sortable:true},
  		{name:'tel', type:'string', sortable:true},
  		{name:'regtime', type:'string', sortable:true},
  		{name:'clazz', type:'string', sortable:true},
  		{name:'qq', type:'string', sortable:true}
  	]
});