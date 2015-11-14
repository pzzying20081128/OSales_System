
	      {
			name : 'combinedproductdetails.productInfo',
			mapping : 'productInfo'
		},
		            		 	      {
			name : 'combinedproductdetails.number',
			mapping : 'number'
		},
		            		 	      		 	      {
			name : 'combinedproductdetails.stockMoneyPriceMoneyShow',
			mapping : 'stockMoneyPriceMoneyShow'
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
					id : 'combinedproductdetails.stockMoneyPriceMoneyShow',
					name : 'combinedproductdetails.stockMoneyPriceMoneyShow',
					fieldLabel : ' 最大采购价',
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