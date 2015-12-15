var stock_return_store_out_detail_grid_column = {
   record : [
         			  {
                    name : 'productInfo.name',
					mapping : 'productInfo'
                },
		 			  {
                    name : 'taxPrice',
					mapping : 'taxPrice'
                },
		 			  {
                    name : 'taxPriceMoneyShow',
					mapping : 'taxPriceMoneyShow'
                },
		 			  {
                    name : 'taxPriceMoneyHide',
					mapping : 'taxPriceMoneyHide'
                },
		 			  {
                    name : 'taxRate',
					mapping : 'taxRate'
                },
		 			  {
                    name : 'taxRateTaxRateShow',
					mapping : 'taxRateTaxRateShow'
                },
		 			  {
                    name : 'taxRateTaxRateHide',
					mapping : 'taxRateTaxRateHide'
                },
		 			  {
                    name : 'taxMoney',
					mapping : 'taxMoney'
                },
		 			  {
                    name : 'taxMoneyMoneyShow',
					mapping : 'taxMoneyMoneyShow'
                },
		 			  {
                    name : 'taxMoneyMoneyHide',
					mapping : 'taxMoneyMoneyHide'
                },
		 			  {
                    name : 'noTaxPrice',
					mapping : 'noTaxPrice'
                },
		 			  {
                    name : 'noTaxPriceMoneyShow',
					mapping : 'noTaxPriceMoneyShow'
                },
		 			  {
                    name : 'noTaxPriceMoneyHide',
					mapping : 'noTaxPriceMoneyHide'
                },
		 			  {
                    name : 'noTaxMoney',
					mapping : 'noTaxMoney'
                },
		 			  {
                    name : 'noTaxMoneyMoneyShow',
					mapping : 'noTaxMoneyMoneyShow'
                },
		 			  {
                    name : 'noTaxMoneyMoneyHide',
					mapping : 'noTaxMoneyMoneyHide'
                },
		 			  {
                    name : 'orderCount',
					mapping : 'orderCount'
                },
		 			  {
                    name : 'orderBox',
					mapping : 'orderBox'
                },
		 			  {
                    name : 'text',
					mapping : 'text'
                },
		 			  {
                    name : 'storeInfo.name',
					mapping : 'storeInfo'
                },
		 			  {
                    name : 'storePosition.name',
					mapping : 'storePosition'
                },
		    ],
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	column : [
	 new Ext.grid.ERPRowNumberer(),
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
                    header : '含税单价',
		            width :   200,
		            dataIndex :'taxPriceMoneyShow',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		    
						   if(value==null ||  typeof(value) =='undefined' )   
  return null   
   else  
 return value ;
						 
		          }
                },
            		 	      		 	      		 	      			  {
                    header : '税率',
		            width :   200,
		            dataIndex :'taxRateTaxRateShow',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		    
						   if(value==null ||  typeof(value) =='undefined' )   
  return null   
   else  
 return value ;
						 
		          }
                },
            		 	      		 	      		 	      			  {
                    header : '含税金额',
		            width :   200,
		            dataIndex :'taxMoneyMoneyShow',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		    
						   if(value==null ||  typeof(value) =='undefined' )   
  return null   
   else  
 return value ;
						 
		          }
                },
            		 	      		 	      		 	      			  {
                    header : '未税单价',
		            width :   200,
		            dataIndex :'noTaxPriceMoneyShow',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		    
						   if(value==null ||  typeof(value) =='undefined' )   
  return null   
   else  
 return value ;
						 
		          }
                },
            		 	      		 	      		 	      			  {
                    header : '未税金额',
		            width :   200,
		            dataIndex :'noTaxMoneyMoneyShow',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		    
						   if(value==null ||  typeof(value) =='undefined' )   
  return null   
   else  
 return value ;
						 
		          }
                },
            		 	      		 	      			  {
                    header : '订购数量',
		            width :   200,
		            dataIndex :'orderCount',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		    
						   if(value==null ||  typeof(value) =='undefined' )   
  return null   
   else  
 return value ;
						 
		          }
                },
            		 	      			  {
                    header : '订购箱数量',
		            width :   200,
		            dataIndex :'orderBox',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		    
						   if(value==null ||  typeof(value) =='undefined' )   
  return null   
   else  
 return value ;
						 
		          }
                },
            		 	      			  {
                    header : '备注',
		            width :   200,
		            dataIndex :'text',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		    
						   if(value==null ||  typeof(value) =='undefined' )   
  return null   
   else  
 return value ;
						 
		          }
                },
            		 	      			  {
                    header : '入库仓库',
		            width :   200,
		            dataIndex :'storeInfo.name',
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
                    header : '入库库位',
		            width :   200,
		            dataIndex :'storePosition.name',
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
            		 	 
	
	
	]
};
////////////////////////////////////////////////////////////////////////////////////

