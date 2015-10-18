
	      {
			name : 'productcategory.parent',
			mapping : 'parent'
		},
		            		 	      		 	      		 	      {
			name : 'productcategory.name',
			mapping : 'name'
		},
		            		 	      {
			name : 'productcategory.text',
			mapping : 'text'
		},
		            		 	      {
			name : 'productcategory.isChild',
			mapping : 'isChild'
		},
		            		 	      {
			name : 'productcategory.status',
			mapping : 'status'
		},
		            		 

	      	      // ----------------------------------------------------------------------//
			  	      		 	      	      // ----------------------------------------------------------------------//
			 
            		 	      	      // ----------------------------------------------------------------------//
			  {
                columnWidth : .25,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 250
				},
				items : [{
					id : 'productcategory.text',
					name : 'productcategory.text',
					fieldLabel : ' 备注',
					xtype : 'textfield',
					style : NoAllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : false,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			  },
            		 	      	      // ----------------------------------------------------------------------//
			  {
                columnWidth : .25,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 250
				},
				items : [{
					id : 'productcategory.isChild',
					name : 'productcategory.isChild',
					fieldLabel : ' 是否有子类别',
					xtype : 'textfield',
					style : NoAllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : false,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			  },
            		 	      	      // ----------------------------------------------------------------------//
			  {
                columnWidth : .25,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 250
				},
				items : [{
					id : 'productcategory.status',
					name : 'productcategory.status',
					fieldLabel : ' 状态',
					xtype : 'textfield',
					style : NoAllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : false,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			  },
            		 

// 1-1