//显示或隐藏修改用户信息面板
var showModifyUser = function(record, mainPanel, showUser){
	if(record.get('id')=='showUser'){
		mainPanel.setTitle(record.get('text'));
		mainPanel.add(showUser).doLayout();
		showUser.show();
		showUser.form.load({
			url : 'common/showUser',
			method : 'POST',
			waitMsg : '数据正在加载...',
			waitTitle : '请稍后',
			timeout : 10,
			failure : function(form, action){
				Ext.Msg.alert('信息', '数据加载失败！');
			}
		});
	} else {
		showUser.hide();
	}
};
//显示或隐藏修改密码面板
var showModifyPass = function(record, mainPanel, modifyPass){
	if(record.get('id')=='modifyPass'){
		mainPanel.setTitle(record.get('text'));
		mainPanel.add(modifyPass).doLayout();
		modifyPass.show();
	} else {
		modifyPass.hide();
	}
};
//显示或隐藏用户消息面板
var showMyMessage = function(record, mainPanel, OldMessagePanel, store){
	if(record.get('id')=='MessageManage'){
		mainPanel.setTitle(record.get('text'));
		mainPanel.add(OldMessagePanel).doLayout();
		OldMessagePanel.show();
		store.load({
			params : {
				start : 0,
				page : 1,
				limit : 15
			}
		});
	} else {
		OldMessagePanel.hide();
	}
};
//显示或隐藏用户审核界面
var showUserAudit = function(record, mainPanel, RegisterUserPanel, store){
	if(record.get('id') == 'UserCheck'){
		mainPanel.setTitle(record.get('text'));
		mainPanel.add(RegisterUserPanel).doLayout();
		RegisterUserPanel.show();
		store.load({
			params : {
				start : 0,
				page : 1,
				limit : 15
			}
		});
	}else{
		RegisterUserPanel.hide();
	}
};
//显示或隐藏临时申领信息审核界面
var showTempBorrowAudit = function(record, mainPanel, TempBorrowPanel, store){
	if(record.get('id') == 'BorrowCheck'){
		mainPanel.setTitle(record.get('text'));
		mainPanel.add(TempBorrowPanel).doLayout();
		TempBorrowPanel.show();
		store.load({
			params : {
				start : 0,
				page : 1,
				limit : 15
			}
		});
	}else{
		TempBorrowPanel.hide();
	}
};
//显示或隐藏临时申购信息审核界面
var showTempPorAudit = function(record, mainPanel, TempPorPanel, store){
	if(record.get('id') == 'PorCheck'){
		mainPanel.setTitle(record.get('text'));
		mainPanel.add(TempPorPanel).doLayout();
		TempPorPanel.show();
		store.load({
			params : {
				start : 0,
				page : 1,
				limit : 15
			}
		});
	}else{
		TempPorPanel.hide();
	}
};
//显示或隐藏申领记录面板
var showBorrowRecordPanel = function(record, mainPanel, BorrowRecordPanel, store){
	if(record.get('id') == 'BorrowRecord'){
		mainPanel.setTitle(record.get('text'));
		mainPanel.add(BorrowRecordPanel).doLayout();
		BorrowRecordPanel.show();
		store.load({
			params : {
				start : 0,
				page : 1,
				limit : 15
			}
		});
	}else{
		BorrowRecordPanel.hide();
	}
};
//显示或隐藏申领记录面板
var showPorRecordPanel = function(record, mainPanel, PorRecordPanel, store){
	if(record.get('id') == 'PorRecord'){
		mainPanel.setTitle(record.get('text'));
		mainPanel.add(PorRecordPanel).doLayout();
		PorRecordPanel.show();
		store.load({
			params : {
				start : 0,
				page : 1,
				limit : 15
			}
		});
	}else{
		PorRecordPanel.hide();
	}
};
//点击保存按钮之后，保存用户信息
var saveModifyUser = function(form) {
	if(form.form.isValid()){
		Ext.MessageBox.confirm('信息','确定要修改你的资料吗？', function(opt){
			if(opt == 'yes'){
				form.form.submit({
					url : 'common/modifyUser',
					method : 'POST',
					success : function(form, action){
						Ext.Msg.alert('信息', '修改成功！');
					},
					failure : function(form, action){
						Ext.Msg.alert('信息', '修改失败，请重新再试！');
					}
				});
			}
		});
	} else {
		Ext.Msg.alert('提示', '请正确填写你的信息！');
	}
};
//修改密码
var modifyPassword = function(form){
	if(form.form.isValid()){
		Ext.Msg.confirm('提示', '确定要修改你的密码吗？', function(opt){
			if(opt == 'yes'){
				form.form.submit({
					url : 'common/modifyPass',
					method : 'POST',
					success : function(form, action){
						Ext.Msg.alert('信息', '密码修改成功，请牢记你的新密码');
					},
					failure : function(form, action){
						Ext.Msg.alert('信息', '密码修改失败，' + action.result.errorMessage);
					}
				});
			}
		});
	} else {
		Ext.Msg.alert('警告', '请正确填写密码后再提交');
	}
};
//删除选中的消息
var deleteMessages = function(grid){
	var record = grid.getSelectionModel().getSelection();
	if(record.length == 0){
		Ext.Msg.alert('提示', '没有选择要删除的数据！');
	}else{
		Ext.Msg.confirm('提示', '确定要删除吗？', function(opt){
			if(opt == 'yes'){
				var selectIds = '';
				for(var i = 0; i < record.length; i++){
					if(i == 0){
						selectIds += record[i].get('id');
					} else {
						selectIds += ',' + record[i].get('id');
					}
				}
		
				Ext.Ajax.request({
					url : 'common/deleteMessage',
					params : {selectIds : selectIds},
					method : 'POST',
					timeout : 10000,
					success : function(response){
						Ext.Msg.alert('信息', '删除成功！');
						for(var i = 0; i < record.length; i++){
							grid.getStore().remove(record[i]);
						}
					},
					failure : function(response){
						Ext.Msg.alert('信息', '删除失败，请重试...');
					}
				});
			}
		});
	}
};
//删除一条消息
var deleteMessage = function(grid, row, col){
	var record = grid.getStore().getAt(row);
	Ext.Msg.confirm('提示', '确定要删除吗？', function(opt){
		if(opt == 'yes'){
			var selectIds = record.get('id');
			
			Ext.Ajax.request({
				url : 'common/deleteMessage',
				params : {selectIds : selectIds},
				method : 'POST',
				timeout : 10000,
				success : function(response){
					Ext.Msg.alert('信息', '删除成功！');
					grid.getStore().remove(record);
				},
				failure : function(response){
					Ext.Msg.alert('信息', '删除失败，请重试...');
				}
			});
		}
	});
};
//同意选中的用户注册
var agreeUsers = function(grid){
	var record = grid.getSelectionModel().getSelection();
	if(record.length == 0){
		Ext.Msg.alert('提示', '没有选择要同意的用户！');
	}else{
		Ext.Msg.confirm('提示', '确定要同意注册吗？', function(opt){
			if(opt == 'yes'){
				var selectIds = '';
				for(var i = 0; i < record.length; i++){
					if(i == 0){
						selectIds += record[i].get('id');
					} else {
						selectIds += ',' + record[i].get('id');
					}
				}
		
				Ext.Ajax.request({
					url : 'admin/agreeUser',
					params : {selectIds : selectIds},
					method : 'POST',
					timeout : 10000,
					success : function(response){
						Ext.Msg.alert('信息', '审核成功！');
						for(var i = 0; i < record.length; i++){
							grid.getStore().remove(record[i]);
						}
					},
					failure : function(response){
						Ext.Msg.alert('信息', '审核失败，请重试...');
					}
				});
			}
		});
	}
};
//同意一个用户的注册
var agreeUser = function(grid, row, col){
	var record = grid.getStore().getAt(row);
	Ext.Msg.confirm('提示', '确定要同意吗？', function(opt){
		if(opt == 'yes'){
			var selectIds = record.get('id');
			
			Ext.Ajax.request({
				url : 'admin/agreeUser',
				params : {selectIds : selectIds},
				method : 'POST',
				timeout : 10000,
				success : function(response){
					Ext.Msg.alert('信息', '审核成功！');
					grid.getStore().remove(record);
				},
				failure : function(response){
					Ext.Msg.alert('信息', '审核失败，请重试...');
				}
			});
		}
	});
};
//拒绝选中的用户注册
var refuseUsers = function(grid){
	var record = grid.getSelectionModel().getSelection();
	if(record.length == 0){
		Ext.Msg.alert('提示', '没有选择要拒绝的用户！');
	}else{
		Ext.Msg.confirm('提示', '确定要拒绝注册吗？', function(opt){
			if(opt == 'yes'){
				var selectIds = '';
				for(var i = 0; i < record.length; i++){
					if(i == 0){
						selectIds += record[i].get('id');
					} else {
						selectIds += ',' + record[i].get('id');
					}
				}
		
				Ext.Ajax.request({
					url : 'admin/refuseUser',
					params : {selectIds : selectIds},
					method : 'POST',
					timeout : 10000,
					success : function(response){
						Ext.Msg.alert('信息', '审核成功！');
						for(var i = 0; i < record.length; i++){
							grid.getStore().remove(record[i]);
						}
					},
					failure : function(response){
						Ext.Msg.alert('信息', '审核失败，请重试...');
					}
				});
			}
		});
	}
};
//拒绝一个用户的注册
var refuseUser = function(grid, row, col){
	var record = grid.getStore().getAt(row);
	Ext.Msg.confirm('提示', '确定要拒绝吗？', function(opt){
		if(opt == 'yes'){
			var selectIds = record.get('id');
			
			Ext.Ajax.request({
				url : 'admin/refuseUser',
				params : {selectIds : selectIds},
				method : 'POST',
				timeout : 10000,
				success : function(response){
					Ext.Msg.alert('信息', '审核成功！');
					grid.getStore().remove(record);
				},
				failure : function(response){
					Ext.Msg.alert('信息', '审核失败，请重试...');
				}
			});
		}
	});
};
//同意选中的申领请求
var agreeBorrows = function(grid){
	var record = grid.getSelectionModel().getSelection();
	if(record.length == 0){
		Ext.Msg.alert('提示', '没有选择要同意的用户申请！');
	}else{
		Ext.Msg.confirm('提示', '确定要同意申请吗？', function(opt){
			if(opt == 'yes'){
				var selectIds = '';
				for(var i = 0; i < record.length; i++){
					if(i == 0){
						selectIds += record[i].get('id');
					} else {
						selectIds += ',' + record[i].get('id');
					}
				}
		
				Ext.Ajax.request({
					url : 'admin/agreeBorrow',
					params : {selectIds : selectIds},
					method : 'POST',
					timeout : 10000,
					success : function(response){
						Ext.Msg.alert('信息', '审核成功！');
						for(var i = 0; i < record.length; i++){
							grid.getStore().remove(record[i]);
						}
					},
					failure : function(response){
						Ext.Msg.alert('信息', '审核失败，请重试...');
					}
				});
			}
		});
	}
};
//同意一个用户的申领请求
var agreeBorrow = function(grid, row, col){
	var record = grid.getStore().getAt(row);
	Ext.Msg.confirm('提示', '确定要同意吗？', function(opt){
		if(opt == 'yes'){
			var selectIds = record.get('id');
			
			Ext.Ajax.request({
				url : 'admin/agreeBorrow',
				params : {selectIds : selectIds},
				method : 'POST',
				timeout : 10000,
				success : function(response){
					Ext.Msg.alert('信息', '审核成功！');
					grid.getStore().remove(record);
				},
				failure : function(response){
					Ext.Msg.alert('信息', '审核失败，请重试...');
				}
			});
		}
	});
};
//拒绝选中的用户申领请求
var refuseBorrows = function(grid){
	var record = grid.getSelectionModel().getSelection();
	if(record.length == 0){
		Ext.Msg.alert('提示', '没有选择要拒绝的用户申请！');
	}else{
		Ext.Msg.confirm('提示', '确定要拒绝申请吗？', function(opt){
			if(opt == 'yes'){
				var selectIds = '';
				for(var i = 0; i < record.length; i++){
					if(i == 0){
						selectIds += record[i].get('id');
					} else {
						selectIds += ',' + record[i].get('id');
					}
				}
		
				Ext.Ajax.request({
					url : 'admin/refuseBorrow',
					params : {selectIds : selectIds},
					method : 'POST',
					timeout : 10000,
					success : function(response){
						Ext.Msg.alert('信息', '审核成功！');
						for(var i = 0; i < record.length; i++){
							grid.getStore().remove(record[i]);
						}
					},
					failure : function(response){
						Ext.Msg.alert('信息', '审核失败，请重试...');
					}
				});
			}
		});
	}
};
//拒绝一个用户的申领请求
var refuseBorrow = function(grid, row, col){
	var record = grid.getStore().getAt(row);
	Ext.Msg.confirm('提示', '确定要拒绝吗？', function(opt){
		if(opt == 'yes'){
			var selectIds = record.get('id');
			
			Ext.Ajax.request({
				url : 'admin/refuseBorrow',
				params : {selectIds : selectIds},
				method : 'POST',
				timeout : 10000,
				success : function(response){
					Ext.Msg.alert('信息', '审核成功！');
					grid.getStore().remove(record);
				},
				failure : function(response){
					Ext.Msg.alert('信息', '审核失败，请重试...');
				}
			});
		}
	});
};
//同意选中的申购请求
var agreePors = function(grid){
	var record = grid.getSelectionModel().getSelection();
	if(record.length == 0){
		Ext.Msg.alert('提示', '没有选择要同意的用户申请！');
	}else{
		Ext.Msg.confirm('提示', '确定要同意申请吗？', function(opt){
			if(opt == 'yes'){
				var selectIds = '';
				for(var i = 0; i < record.length; i++){
					if(i == 0){
						selectIds += record[i].get('id');
					} else {
						selectIds += ',' + record[i].get('id');
					}
				}
		
				Ext.Ajax.request({
					url : 'admin/agreePor',
					params : {selectIds : selectIds},
					method : 'POST',
					timeout : 10000,
					success : function(response){
						Ext.Msg.alert('信息', '审核成功！');
						for(var i = 0; i < record.length; i++){
							grid.getStore().remove(record[i]);
						}
					},
					failure : function(response){
						Ext.Msg.alert('信息', '审核失败，请重试...');
					}
				});
			}
		});
	}
};
//同意一个用户的申购请求
var agreePor = function(grid, row, col){
	var record = grid.getStore().getAt(row);
	Ext.Msg.confirm('提示', '确定要同意吗？', function(opt){
		if(opt == 'yes'){
			var selectIds = record.get('id');
			
			Ext.Ajax.request({
				url : 'admin/agreePor',
				params : {selectIds : selectIds},
				method : 'POST',
				timeout : 10000,
				success : function(response){
					Ext.Msg.alert('信息', '审核成功！');
					grid.getStore().remove(record);
				},
				failure : function(response){
					Ext.Msg.alert('信息', '审核失败，请重试...');
				}
			});
		}
	});
};
//拒绝选中的用户申购请求
var refusePors = function(grid){
	var record = grid.getSelectionModel().getSelection();
	if(record.length == 0){
		Ext.Msg.alert('提示', '没有选择要拒绝的用户申请！');
	}else{
		Ext.Msg.confirm('提示', '确定要拒绝申请吗？', function(opt){
			if(opt == 'yes'){
				var selectIds = '';
				for(var i = 0; i < record.length; i++){
					if(i == 0){
						selectIds += record[i].get('id');
					} else {
						selectIds += ',' + record[i].get('id');
					}
				}
		
				Ext.Ajax.request({
					url : 'admin/refusePor',
					params : {selectIds : selectIds},
					method : 'POST',
					timeout : 10000,
					success : function(response){
						Ext.Msg.alert('信息', '审核成功！');
						for(var i = 0; i < record.length; i++){
							grid.getStore().remove(record[i]);
						}
					},
					failure : function(response){
						Ext.Msg.alert('信息', '审核失败，请重试...');
					}
				});
			}
		});
	}
};
//拒绝一个用户的申领请求
var refusePor = function(grid, row, col){
	var record = grid.getStore().getAt(row);
	Ext.Msg.confirm('提示', '确定要拒绝吗？', function(opt){
		if(opt == 'yes'){
			var selectIds = record.get('id');
			
			Ext.Ajax.request({
				url : 'admin/refusePor',
				params : {selectIds : selectIds},
				method : 'POST',
				timeout : 10000,
				success : function(response){
					Ext.Msg.alert('信息', '审核成功！');
					grid.getStore().remove(record);
				},
				failure : function(response){
					Ext.Msg.alert('信息', '审核失败，请重试...');
				}
			});
		}
	});
};
//标记选中的消息
var checkMessage = function(grid, row, col){
	var record = grid.getStore().getAt(row);
	var selectIds = record.get('id');
	
	Ext.Ajax.request({
		url : 'common/checkMessage',
		params : {selectIds : selectIds},
		method : 'POST',
		timeout : 10000,
		success : function(response){
			grid.getStore().remove(record);
		},
		failure : function(response){
			Ext.Msg.alert('信息', '删除失败，请重试...');
		}
	});
};
//标记选中的消息
var checkMessages = function(grid){
	var record = grid.getSelectionModel().getSelection();
	if(record.length == 0){
		Ext.Msg.alert('提示', '没有选择要标记的数据！');
	}else{
		var selectIds = '';
		for(var i = 0; i < record.length; i++){
			if(i == 0){
				selectIds += record[i].get('id');
			} else {
				selectIds += ',' + record[i].get('id');
			}
		}

		Ext.Ajax.request({
			url : 'common/checkMessage',
			params : {selectIds : selectIds},
			method : 'POST',
			timeout : 10000,
			success : function(response){
				for(var i = 0; i < record.length; i++){
					grid.getStore().remove(record[i]);
				}
			},
			failure : function(response){
				Ext.Msg.alert('信息', '标记失败，请重试...');
			}
		});
	}
};