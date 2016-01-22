var stock_in_out_detail_report_grid_column = {
   record : [
         			  {
                    name : 'billType',
					mapping : 'billType'
                },
		 			  {
                    name : 'billNum',
					mapping : 'billNum'
                },
		 			  {
                    name : 'providerInfo.name',
					mapping : 'providerInfo'
                },
		 			  {
                    name : 'providerInfoId',
					mapping : 'providerInfoId'
                },
		 			  {
                    name : 'productInfo.name',
					mapping : 'productInfo'
                },
		 			  {
                    name : 'stockTaxSumMoney',
					mapping : 'stockTaxSumMoney'
                },
		 			  {
                    name : 'stockTaxSumMoneyMoneyShow',
					mapping : 'stockTaxSumMoneyMoneyShow'
                },
		 			  {
                    name : 'stockTaxSumMoneyMoneyHide',
					mapping : 'stockTaxSumMoneyMoneyHide'
                },
		 			  {
                    name : 'stockNoTaxSumMoney',
					mapping : 'stockNoTaxSumMoney'
                },
		 			  {
                    name : 'stockNoTaxSumMoneyMoneyShow',
					mapping : 'stockNoTaxSumMoneyMoneyShow'
                },
		 			  {
                    name : 'stockNoTaxSumMoneyMoneyHide',
					mapping : 'stockNoTaxSumMoneyMoneyHide'
                },
		 			  {
                    name : 'stockCount',
					mapping : 'stockCount'
                },
		 			  {
                    name : 'returnGoodsTaxSumMoney',
					mapping : 'returnGoodsTaxSumMoney'
                },
		 			  {
                    name : 'returnGoodsTaxSumMoneyMoneyShow',
					mapping : 'returnGoodsTaxSumMoneyMoneyShow'
                },
		 			  {
                    name : 'returnGoodsTaxSumMoneyMoneyHide',
					mapping : 'returnGoodsTaxSumMoneyMoneyHide'
                },
		 			  {
                    name : 'returnGoodsNoTaxSumMoney',
					mapping : 'returnGoodsNoTaxSumMoney'
                },
		 			  {
                    name : 'returnGoodsNoTaxSumMoneyMoneyShow',
					mapping : 'returnGoodsNoTaxSumMoneyMoneyShow'
                },
		 			  {
                    name : 'returnGoodsNoTaxSumMoneyMoneyHide',
					mapping : 'returnGoodsNoTaxSumMoneyMoneyHide'
                },
		 			  {
                    name : 'returnGoodsCount',
					mapping : 'returnGoodsCount'
                },
		 			  {
                    name : 'stockAdjustSumMoney',
					mapping : 'stockAdjustSumMoney'
                },
		 			  {
                    name : 'stockAdjustSumMoneyMoneyShow',
					mapping : 'stockAdjustSumMoneyMoneyShow'
                },
		 			  {
                    name : 'stockAdjustSumMoneyMoneyHide',
					mapping : 'stockAdjustSumMoneyMoneyHide'
                },
		 			  {
                    name : 'status',
					mapping : 'status'
                },
		    ],
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	column : [
	 new Ext.grid.ERPRowNumberer(),
	   	      			  {
                    header : '单据类型',
		            width :   200,
		            dataIndex :'billType',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		    
						   if(value==null ||  typeof(value) =='undefined' )   
  return null   
   else  
 return value ;
						 
		          }
                },
            		 	      			  {
                    header : '单据编号',
		            width :   200,
		            dataIndex :'billNum',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		    
						   if(value==null ||  typeof(value) =='undefined' )   
  return null   
   else  
 return value ;
						 
		          }
                },
            		 	      			  {
                    header : '供应商',
		            width :   200,
		            dataIndex :'providerInfo.name',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		    
						   if(value==null ||  typeof(value) =='undefined' )   
  return null   
   else  
if(value.name==null ||  typeof(value.name) =='undefined' )   
  return null   
   else  
 return value.name ;
						 
		          }
                },
            		 	      		 	      			  {
                    header : '产品',
		            width :   200,
		            dataIndex :'productInfo.name',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		    
						   if(value==null ||  typeof(value) =='undefined' )   
  return null   
   else  
if(value.name==null ||  typeof(value.name) =='undefined' )   
  return null   
   else  
 return value.name ;
						 
		          }
                },
            		 	      		 	      			  {
                    header : '进货含税总金额',
		            width :   200,
		            dataIndex :'stockTaxSumMoneyMoneyShow',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		    
						   if(value==null ||  typeof(value) =='undefined' )   
  return null   
   else  
 return value ;
						 
		          }
                },
            		 	      		 	      		 	      			  {
                    header : '进货末税总金额',
		            width :   200,
		            dataIndex :'stockNoTaxSumMoneyMoneyShow',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		    
						   if(value==null ||  typeof(value) =='undefined' )   
  return null   
   else  
 return value ;
						 
		          }
                },
            		 	      		 	      			  {
                    header : '进货数量',
		            width :   200,
		            dataIndex :'stockCount',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		    
						   if(value==null ||  typeof(value) =='undefined' )   
  return null   
   else  
 return value ;
						 
		          }
                },
            		 	      		 	      			  {
                    header : '退货含税总金额',
		            width :   200,
		            dataIndex :'returnGoodsTaxSumMoneyMoneyShow',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		    
						   if(value==null ||  typeof(value) =='undefined' )   
  return null   
   else  
 return value ;
						 
		          }
                },
            		 	      		 	      		 	      			  {
                    header : '退货末税总金额',
		            width :   200,
		            dataIndex :'returnGoodsNoTaxSumMoneyMoneyShow',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		    
						   if(value==null ||  typeof(value) =='undefined' )   
  return null   
   else  
 return value ;
						 
		          }
                },
            		 	      		 	      			  {
                    header : '退货数量',
		            width :   200,
		            dataIndex :'returnGoodsCount',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		    
						   if(value==null ||  typeof(value) =='undefined' )   
  return null   
   else  
 return value ;
						 
		          }
                },
            		 	      		 	      			  {
                    header : '采购调整金额',
		            width :   200,
		            dataIndex :'stockAdjustSumMoneyMoneyShow',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		    
						   if(value==null ||  typeof(value) =='undefined' )   
  return null   
   else  
 return value ;
						 
		          }
                },
            		 	      		 	      			  {
                    header : '状态',
		            width :   200,
		            dataIndex :'status',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		    
						   if(value==null ||  typeof(value) =='undefined' )   
  return null   
   else  
 return value ;
						 
		          }
                },
            		 	 
	
	
	]
};
////////////////////////////////////////////////////////////////////////////////////

