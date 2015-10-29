Ext.namespace("Ext.ux.grid.livegrid");
Ext.ux.grid.livegrid.GridPanel = Ext.extend(Ext.grid.GridPanel, {
	initComponent : function() {
		if (this.cls) {
			this.cls += " ext-ux-livegrid"
		} else {
			this.cls = "ext-ux-livegrid"
		}
		Ext.ux.grid.livegrid.GridPanel.superclass.initComponent.call(this)
	},
	initStateEvents : function() {
		var A = this;
		Ext.ux.grid.livegrid.GridPanel.superclass.initStateEvents.call(A);
		this.installStateEvents(true)
	},
	installStateEvents : function(C) {
		var B = this;
		if (C === false) {
			B.mun(B.view, "buffer", B.saveState, B);
			B.mun(B.view, "cursormove", B.saveState, B);
			B.mun(B.store, "remove", B.saveState, B);
			B.mun(B.store, "add", B.saveState, B);
			B.mun(B.store, "bulkremove", B.saveState);
			B.mun(B.store, "clear", B.saveState, B);
			B.mun(B.selModel, "selectionchange", B.saveState, B)
		} else {
			var A = {
				delay : 100
			};
			B.mon(B.view, "buffer", B.saveState, B, A);
			B.mon(B.view, "cursormove", B.saveState, B, A);
			B.mon(B.store, "remove", B.saveState, B, A);
			B.mon(B.store, "add", B.saveState, B, A);
			B.mon(B.store, "bulkremove", B.saveState, B, A);
			B.mon(B.store, "clear", B.saveState, B, A);
			B.mon(B.selModel, "selectionchange", B.saveState, B, A)
		}
	},
	reloadFromState : function(B) {
		var A = this;
		if (!A.stateId || !B) {
			A.view.reset(true);
			return
		}
		A.installStateEvents(false);
		A.applyState.apply(A, arguments);
		A.installStateEvents(true);
		A.view.reset(true)
	},
	getState : function() {
		var B = null, A = this;
		B = Ext.ux.grid.livegrid.GridPanel.superclass.getState.apply(A);
		Ext.apply(B, {
			bufferRange : A.store.bufferRange,
			rowIndex : A.view.rowIndex,
			lastScrollPos : A.view.lastScrollPos,
			lastRowIndex : A.view.lastRowIndex,
			lastIndex : A.view.lastIndex,
			selections : A.selModel.getState()
		});
		return B
	},
	applyState : function(F) {
		var E = this, C = F.selections, A = F.bufferRange ? Math.max(Math.max(F.bufferRange[0], F.rowIndex), 0) : 0, B = {
			rowIndex : F.rowIndex,
			lastScrollPos : F.lastScrollPos,
			lastRowIndex : F.lastRowIndex,
			lastIndex : F.lastIndex
		};
		var D = Ext.createDelegate(function(H, J, I, K, G) {
			Ext.apply(J, {
				forceStart : true,
				callback : function() {
					E.selModel.clearSelections(true);
					E.view.reset(I);
					if (K) {
						E.selModel.applyState(K)
					}
				}
			});
			Ext.apply(J.params, {
				start : G
			})
		}, E, [B, C, A], true);
		Ext.ux.grid.livegrid.GridPanel.superclass.applyState.apply(E, arguments);
		E.store.on("beforeload", D, E, {
			single : true
		})
	},
	onRender : function(B, A) {
		Ext.ux.grid.livegrid.GridPanel.superclass.onRender.call(this, B, A);
		var C = this.getStore();
		if (C._autoLoad === true) {
			delete C._autoLoad;
			C.load()
		}
	},
	walkCells : function(H, C, F, E, D) {
		var G = this.store;
		var A = G.getCount;
		G.getCount = G.getTotalCount;
		var B = Ext.ux.grid.livegrid.GridPanel.superclass.walkCells.call(this, H, C, F, E, D);
		G.getCount = A;
		return B
	}
});
Ext.namespace("Ext.ux.grid.livegrid");
Ext.ux.grid.livegrid.GridView = function(A) {
	this.addEvents({
		reset : true,
		beforebuffer : true,
		buffer : true,
		bufferfailure : true,
		cursormove : true,
		abortrequest : true
	});
	this.horizontalScrollOffset = 17;
	this._checkEmptyBody = true;
	Ext.apply(this, A);
	this.templates = {};
	this.templates.master = new Ext.Template('<div class="x-grid3" hidefocus="true"><div class="liveScroller"><div></div><div></div><div></div></div>', '<div class="x-grid3-viewport"">', '<div class="x-grid3-header"><div class="x-grid3-header-inner"><div class="x-grid3-header-offset" style="{ostyle}">{header}</div></div><div class="x-clear"></div></div>', '<div class="x-grid3-scroller" style="overflow-y:hidden !important;"><div class="x-grid3-body" style="{bstyle}">{body}</div><a href="#" class="x-grid3-focus" tabIndex="-1"></a></div>', "</div>", '<div class="x-grid3-resize-marker">&#160;</div>', '<div class="x-grid3-resize-proxy">&#160;</div>', "</div>");
	this._gridViewSuperclass = Ext.ux.grid.livegrid.GridView.superclass;
	this._gridViewSuperclass.constructor.call(this)
};
Ext.extend(Ext.ux.grid.livegrid.GridView, Ext.grid.GridView, {
	hdHeight : 0,
	rowClipped : 0,
	liveScroller : null,
	liveScrollerInsets : null,
	rowHeight : -1,
	visibleRows : 1,
	lastIndex : -1,
	lastRowIndex : 0,
	lastScrollPos : 0,
	rowIndex : 0,
	isBuffering : false,
	requestQueue : -1,
	loadMask : false,
	loadMaskDisplayed : false,
	isPrebuffering : false,
	_loadMaskAnchor : null,
	reset : function(H, G) {
		if (H === false || Ext.isObject(H)) {
			var D = H || {};
			this.ds.modified = [];
			this.rowIndex = D.rowIndex !== undefined ? D.rowIndex : 0;
			this.lastScrollPos = D.lastScrollPos !== undefined ? D.lastScrollPos : 0;
			this.lastRowIndex = D.lastRowIndex !== undefined ? D.lastRowIndex : 0;
			this.lastIndex = D.lastIndex !== undefined ? D.lastIndex : 0;
			this.adjustVisibleRows();
			this.showLoadMask(false);
			var B = this.processRows;
			this.processRows = Ext.emptyFn;
			this.suspendEvents();
			this.refresh(true);
			this.resumeEvents();
			this.processRows = B;
			this.processRows(0);
			this.adjustScrollerPos(-this.liveScroller.dom.scrollTop + 1, true);
			this.adjustScrollerPos(this.rowIndex * this.rowHeight, true);
			this.fireEvent("cursormove", this, this.rowIndex, Math.min(this.ds.totalLength, this.visibleRows - this.rowClipped), this.ds.totalLength);
			this.fireEvent("reset", this, false);
			return false
		} else {
			var F = Ext.apply({}, G), A = this.ds.sortInfo;
			var C = this.ds.paramNames, E = {};
			E[C.dir] = A.direction;
			E[C.sort] = A.field;
			if (A) {
				F = Ext.apply(F, E)
			}
			this.fireEvent("reset", this, H, F);
			return this.ds.load({
				params : F
			})
		}
	},
	afterRenderUI : function() {
		var A = this.grid;
		var C = A.enableDragDrop || A.enableDrag;
		A.enableDragDrop = false;
		A.enableDrag = false;
		this._gridViewSuperclass.afterRenderUI.call(this);
		var A = this.grid;
		A.enableDragDrop = C;
		A.enableDrag = C;
		if (C) {
			this.dragZone = new Ext.ux.grid.livegrid.DragZone(A, {
				ddGroup : A.ddGroup || "GridDD"
			})
		}
		if (this.loadMask) {
			this._loadMaskAnchor = Ext.get(this.mainBody.dom.parentNode.parentNode);
			Ext.apply(this.loadMask, {
				msgCls : "x-mask-loading"
			});
			this._loadMaskAnchor.mask(this.loadMask.msg, this.loadMask.msgCls);
			var D = this._loadMaskAnchor.dom;
			var B = Ext.Element.data;
			B(D, "mask").addClass("ext-ux-livegrid");
			B(D, "mask").setDisplayed(false);
			B(D, "maskMsg").setDisplayed(false)
		}
	},
	init : function(A) {
		this._gridViewSuperclass.init.call(this, A);
		A.on("expand", this._onExpand, this)
	},
	initData : function(B, A) {
		if (this.ds) {
			this.ds.un("bulkremove", this.onBulkRemove, this);
			this.ds.un("beforeload", this.onBeforeLoad, this)
		}
		if (B) {
			B.on("bulkremove", this.onBulkRemove, this);
			B.on("beforeload", this.onBeforeLoad, this)
		}
		this._gridViewSuperclass.initData.call(this, B, A)
	},
	renderBody : function() {
		if (this.ds.bufferRange[0] < 0) {
			return this.templates.body.apply({
				rows : ""
			})
		}
		var A = this.renderRows(this.rowIndex - this.ds.bufferRange[0], ( this.rowIndex - this.ds.bufferRange[0] ) + ( this.visibleRows - 1 ));
		return this.templates.body.apply({
			rows : A
		})
	},
	doRender : function(C, B, E, A, D, F) {
		return this._gridViewSuperclass.doRender.call(this, C, B, E, A + this.ds.bufferRange[0], D, F)
	},
	initElements : function() {
		var F = Ext.Element;
		var B = this.grid.getGridEl().dom.firstChild;
		var A = B.childNodes;
		this.el = new F(B);
		this.mainWrap = new F(A[1]);
		this.liveScroller = new F(A[0]);
		var D = this.liveScroller.dom.firstChild;
		this.liveScrollerInsets = [D, D.nextSibling, D.nextSibling.nextSibling];
		this.liveScroller.on("scroll", this.onLiveScroll, this, {
			buffer : this.scrollDelay
		});
		var C = this.mainWrap.dom.firstChild;
		this.mainHd = new F(C);
		this.hdHeight = C.offsetHeight;
		this.innerHd = this.mainHd.dom.firstChild;
		this.scroller = new F(this.mainWrap.dom.childNodes[1]);
		if (this.forceFit) {
			this.scroller.setStyle("overflow-x", "hidden")
		}
		this.mainBody = new F(this.scroller.dom.firstChild);
		this.mainBody.on("mousewheel", this.handleWheel, this);
		this.focusEl = new F(this.scroller.dom.childNodes[1]);
		this.focusEl.swallowEvent("click", true);
		this.resizeMarker = new F(A[2]);
		this.resizeProxy = new F(A[3])
	},
	layout : function() {
		if (!this.mainBody) {
			return
		}
		var E = this.grid;
		var G = E.getGridEl(), I = this.cm, B = E.autoExpandColumn, A = this;
		var C = G.getSize(true);
		var H = C.width;
		if (!E.hideHeaders && H < 20 || C.height < 20) {
			return
		}
		if (E.autoHeight) {
			this.scroller.dom.style.overflow = "visible";
			if (Ext.isWebKit) {
				this.scroller.dom.style.position = "static"
			}
		} else {
			this.el.setSize(C.width, C.height);
			var F = this.mainHd.getHeight();
			var D = C.height - ( F );
			this.scroller.setSize(H, D);
			if (this.innerHd) {
				this.innerHd.style.width = ( H ) + "px"
			}
		}
		this.liveScroller.dom.style.top = this.hdHeight + "px";
		if (this.forceFit) {
			if (this.lastViewWidth != H) {
				this.fitColumns(false, false);
				this.lastViewWidth = H
			}
		} else {
			this.autoExpand()
		}
		this.adjustVisibleRows();
		this.adjustBufferInset();
		this.onLayout(H, D)
	},
	removeRow : function(A) {
		Ext.removeNode(this.getRow(A))
	},
	removeRows : function(C, A) {
		var B = this.mainBody.dom;
		for (var D = C; D <= A; D++) {
			Ext.removeNode(B.childNodes[C])
		}
	},
	_onExpand : function(A) {
		this.adjustVisibleRows();
		this.adjustBufferInset();
		this.adjustScrollerPos(this.rowHeight * this.rowIndex, true)
	},
	onColumnMove : function(A, C, B) {
		this.indexMap = null;
		this.replaceLiveRows(this.rowIndex, true);
		this.updateHeaders();
		this.updateHeaderSortState();
		this.afterMove(B);
		this.grid.fireEvent("columnmove", C, B)
	},
	onColumnWidthUpdated : function(C, A, B) {
		this.adjustVisibleRows();
		this.adjustBufferInset()
	},
	onAllColumnWidthsUpdated : function(A, B) {
		this.adjustVisibleRows();
		this.adjustBufferInset()
	},
	onRowSelect : function(A) {
		if (A < this.rowIndex || A > this.rowIndex + this.visibleRows) {
			return
		}
		this.addRowClass(A, this.selectedRowClass)
	},
	onRowDeselect : function(A) {
		if (A < this.rowIndex || A > this.rowIndex + this.visibleRows) {
			return
		}
		this.removeRowClass(A, this.selectedRowClass)
	},
	onClear : function() {
		this.reset(false)
	},
	onBulkRemove : function(L, M) {
		var H = null;
		var J = 0;
		var O = 0;
		var K = M.length;
		var A = false;
		var I = false;
		var F = 0;
		if (K == 0) {
			return
		}
		var C = this.rowIndex;
		var B = 0;
		var E = 0;
		var D = 0;
		for (var G = 0; G < K; G++) {
			H = M[G][0];
			J = M[G][1];
			O = ( J != Number.MIN_VALUE && J != Number.MAX_VALUE ) ? J + this.ds.bufferRange[0] : J;
			if (O < this.rowIndex) {
				B++
			} else {
				if (O >= this.rowIndex && O <= this.rowIndex + ( this.visibleRows - 1 )) {
					D++
				} else {
					if (O >= this.rowIndex + this.visibleRows) {
						E++
					}
				}
			}
			this.fireEvent("beforerowremoved", this, O, H);
			this.fireEvent("rowremoved", this, O, H)
		}
		var N = this.ds.totalLength;
		this.rowIndex = Math.max(0, Math.min(this.rowIndex - B, N - ( this.visibleRows - 1 )));
		this.lastRowIndex = this.rowIndex;
		this.adjustScrollerPos(- ( B * this.rowHeight ), true);
		this.updateLiveRows(this.rowIndex, true);
		this.adjustBufferInset();
		this.processRows(0, undefined, false)
	},
	onRemove : function(C, A, B) {
		this.onBulkRemove(C, [[A, B]])
	},
	onAdd : function(B, C, L, E) {
		if (this._checkEmptyBody) {
			if (this.mainBody.dom.innerHTML == "&nbsp;") {
				this.mainBody.dom.innerHTML = ""
			}
			this._checkEmptyBody = false
		}
		if (E) {
			var D = F + B.bufferRange[0], I = M + B.bufferRange[0], H;
			this.lastRowIndex = this.rowIndex;
			this.rowIndex++;
			F = L - 1;
			M = L - 1;
			H = this.renderRows(F, M);
			Ext.DomHelper.insertHtml("beforeEnd", this.mainBody.dom, H);
			this.fireEvent("rowsinserted", this, D, I, ( I - D ) + 1);
			this.processRows(0, undefined, true);
			this.adjustVisibleRows();
			this.adjustBufferInset();
			this.adjustScrollerPos(this.rowHeight);
			return
		}
		var K = C.length;
		if (L == Number.MAX_VALUE || L == Number.MIN_VALUE) {
			this.fireEvent("beforerowsinserted", this, L, L);
			if (L == Number.MIN_VALUE) {
				this.rowIndex = this.rowIndex + K;
				this.lastRowIndex = this.rowIndex;
				this.adjustBufferInset();
				this.adjustScrollerPos(this.rowHeight * K, true);
				this.fireEvent("rowsinserted", this, L, L, K);
				this.processRows(0, undefined, false);
				this.fireEvent("cursormove", this, this.rowIndex, Math.min(this.ds.totalLength, this.visibleRows - this.rowClipped), this.ds.totalLength);
				return
			}
			this.adjustBufferInset();
			this.fireEvent("rowsinserted", this, L, L, K);
			return
		}
		var A = L + this.ds.bufferRange[0];
		var G = A + ( K - 1 );
		var J = this.getRows().length;
		var F = 0;
		var M = 0;
		if (A > this.rowIndex + ( this.visibleRows - 1 )) {
			this.fireEvent("beforerowsinserted", this, A, G);
			this.fireEvent("rowsinserted", this, A, G, K);
			this.adjustVisibleRows();
			this.adjustBufferInset()
		} else {
			if (A >= this.rowIndex && A <= this.rowIndex + ( this.visibleRows - 1 )) {
				F = L;
				M = L + ( K - 1 );
				this.lastRowIndex = this.rowIndex;
				this.rowIndex = ( A > this.rowIndex ) ? this.rowIndex : A;
				this.insertRows(B, F, M);
				if (this.lastRowIndex != this.rowIndex) {
					this.fireEvent("cursormove", this, this.rowIndex, Math.min(this.ds.totalLength, this.visibleRows - this.rowClipped), this.ds.totalLength)
				}
				this.adjustVisibleRows();
				this.adjustBufferInset()
			} else {
				if (A < this.rowIndex) {
					this.fireEvent("beforerowsinserted", this, A, G);
					this.rowIndex = this.rowIndex + K;
					this.lastRowIndex = this.rowIndex;
					this.adjustVisibleRows();
					this.adjustBufferInset();
					this.adjustScrollerPos(this.rowHeight * K, true);
					this.fireEvent("rowsinserted", this, A, G, K);
					this.processRows(0, undefined, true);
					this.fireEvent("cursormove", this, this.rowIndex, Math.min(this.ds.totalLength, this.visibleRows - this.rowClipped), this.ds.totalLength)
				}
			}
		}
	},
	onBeforeLoad : function(B, D) {
		this.ds.removeAll(true);
		var E = B.proxy;
		if (E.activeRequest && E.activeRequest[Ext.data.Api.actions.read]) {
			E.getConnection().abort(E.activeRequest[Ext.data.Api.actions.read])
		}
		this.fireEvent("abortrequest", B, D);
		this.isBuffering = false;
		this.isPreBuffering = false;
		D.params = D.params || {};
		var A = Ext.apply;
		if (!D.callback) {
			D.callback = function() {
				this.reset(false)
			}
		}
		if (!D.scope) {
			D.scope = this
		}
		D.suspendLoadEvent = false;
		var C = B.paramNames, F = {};
		F[C.start] = D.forceStart === true && D.params.start ? D.params.start : 0;
		F[C.limit] = this.ds.bufferSize;
		A(D.params, F);
		return true
	},
	onLoad : function(C, B, A) {
		this.adjustBufferInset()
	},
	onDataChange : function(A) {
		this.updateHeaderSortState()
	},
	liveBufferUpdate : function(A, B, D) {
		if (D === true) {
			this.adjustBufferInset();
			this.fireEvent("buffer", this, this.ds, this.rowIndex, Math.min(this.ds.totalLength, this.visibleRows - this.rowClipped), this.ds.totalLength, B);
			this.grid.selModel.replaceSelections(A);
			this.isBuffering = false;
			this.isPrebuffering = false;
			this.showLoadMask(false);
			if (this.requestQueue >= 0) {
				var C = this.requestQueue;
				this.requestQueue = -1;
				this.updateLiveRows(C);
				return
			}
			if (this.isInRange(this.rowIndex)) {
				this.replaceLiveRows(this.rowIndex, B.forceRepaint)
			} else {
				this.updateLiveRows(this.rowIndex)
			}
			return
		} else {
			this.fireEvent("bufferfailure", this, this.ds, B);
			this.ds.removeAll();
			this.removeRows(0, this.visibleRows);
			this.isBuffering = false;
			this.isPrebuffering = false;
			if (this.requestQueue >= 0) {
				var C = this.requestQueue;
				this.requestQueue = -1;
				this.updateLiveRows(C);
				return
			}
		}
		this.isBuffering = false;
		this.isPrebuffering = false;
		this.requestQueue = -1;
		this.showLoadMask(false)
	},
	handleWheel : function(A) {
		if (this.rowHeight == -1) {
			A.stopEvent();
			return
		}
		var B = A.getWheelDelta();
		this.adjustScrollerPos(- ( B * this.rowHeight ));
		A.stopEvent()
	},
	onLiveScroll : function() {
		var A = this.liveScroller.dom.scrollTop;
		var B = Math.floor( ( A ) / this.rowHeight);
		this.rowIndex = B;
		if (B == this.lastRowIndex) {
			return
		}
		this.updateLiveRows(B);
		this.lastScrollPos = this.liveScroller.dom.scrollTop
	},
	refreshRow : function(A) {
		var D = this.ds, C;
		if (typeof A == "number") {
			C = A;
			A = D.getAt(C)
		} else {
			C = D.indexOf(A)
		}
		var B = C + this.ds.bufferRange[0];
		if (B < this.rowIndex || B >= this.rowIndex + this.visibleRows) {
			this.fireEvent("rowupdated", this, B, A);
			return
		}
		this.insertRows(D, C, C, true);
		this.fireEvent("rowupdated", this, B, A)
	},
	processRows : function(H, E, B) {
		if (!this.ds || this.ds.getCount() < 1) {
			return
		}
		E = E || !this.grid.stripeRows;
		var I = this.rowIndex;
		var K = this.getRows();
		var D = 0;
		var A = this.grid.selModel;
		var G = A.isAllSelected();
		var J = null;
		for (var F = 0, C = K.length; F < C; F++) {
			J = K[F];
			J.rowIndex = D = I + F;
			J.className = J.className.replace(this.rowClsRe, " ");
			if (!E && ( D + 1 ) % 2 === 0) {
				J.className += " x-grid3-row-alt"
			}
			if (B !== false) {
				if (A.isSelected(this.ds.getAt(D)) === true) {
					this.addRowClass(D, this.selectedRowClass)
				} else {
					this.removeRowClass(D, this.selectedRowClass)
				}
				this.fly(J).removeClass("x-grid3-row-over")
			}
		}
		if (I === 0) {
			Ext.fly(K[0]).addClass(this.firstRowCls)
		} else {
			if (I + K.length == this.ds.totalLength) {
				Ext.fly(K[K.length - 1]).addClass(this.lastRowCls)
			}
		}
	},
	insertRows : function(E, B, M, L) {
		var A = B + this.ds.bufferRange[0];
		var F = M + this.ds.bufferRange[0];
		if (!L) {
			this.fireEvent("beforerowsinserted", this, A, F)
		}
		if (L !== true && ( this.getRows().length + ( M - B ) ) >= this.visibleRows) {
			this.removeRows( ( this.visibleRows - 1 ) - ( M - B ), this.visibleRows - 1)
		} else {
			if (L) {
				this.removeRows(A - this.rowIndex, F - this.rowIndex)
			}
		}
		var G = ( B == M ) ? M : Math.min(M, ( this.rowIndex - this.ds.bufferRange[0] ) + ( this.visibleRows - 1 ));
		var D = this.renderRows(B, G);
		var I = this.getRow(A);
		if (I) {
			Ext.DomHelper.insertHtml("beforeBegin", I, D)
		} else {
			Ext.DomHelper.insertHtml("beforeEnd", this.mainBody.dom, D)
		}
		if (L === true) {
			var K = this.getRows();
			var J = this.rowIndex;
			for (var C = 0, H = K.length; C < H; C++) {
				K[C].rowIndex = J + C
			}
		}
		if (!L) {
			this.fireEvent("rowsinserted", this, A, F, ( F - A ) + 1);
			this.processRows(0, undefined, true)
		}
	},
	getRow : function(A) {
		if (A - this.rowIndex < 0) {
			return null
		}
		return this.getRows()[A - this.rowIndex]
	},
	getCell : function(B, A) {
		var B = this.getRow(B);
		return B ? B.getElementsByTagName("td")[A] : null
	},
	focusCell : function(D, A, C) {
		var B = this.ensureVisible(D, A, C);
		if (!B) {
			return
		}
		this.focusEl.setXY(B);
		if (Ext.isGecko) {
			this.focusEl.focus()
		} else {
			this.focusEl.focus.defer(1, this.focusEl)
		}
	},
	ensureVisible : function(K, C, B) {
		if (typeof K != "number") {
			K = K.rowIndex
		}
		if (K < 0 || K >= this.ds.totalLength) {
			return
		}
		C = ( C !== undefined ? C : 0 );
		var H = K - this.rowIndex;
		if (this.rowClipped && K == this.rowIndex + this.visibleRows - 1) {
			this.adjustScrollerPos(this.rowHeight)
		} else {
			if (K >= this.rowIndex + this.visibleRows) {
				this.adjustScrollerPos( ( ( K - ( this.rowIndex + this.visibleRows ) ) + 1 ) * this.rowHeight)
			} else {
				if (K <= this.rowIndex) {
					this.adjustScrollerPos( ( H ) * this.rowHeight)
				}
			}
		}
		var G = this.getRow(K), D;
		if (!G) {
			return
		}
		if (! ( B === false && C === 0 )) {
			while (this.cm.isHidden(C)) {
				C++
			}
			D = this.getCell(K, C)
		}
		var J = this.scroller.dom;
		if (B !== false) {
			var I = parseInt(D.offsetLeft, 10);
			var F = I + D.offsetWidth;
			var E = parseInt(J.scrollLeft, 10);
			var A = E + J.clientWidth;
			if (I < E) {
				J.scrollLeft = I
			} else {
				if (F > A) {
					J.scrollLeft = F - J.clientWidth
				}
			}
		}
		return D ? Ext.fly(D).getXY() : [J.scrollLeft + this.el.getX(), Ext.fly(G).getY()]
	},
	isRecordRendered : function(A) {
		var B = this.ds.indexOf(A);
		if (B >= this.rowIndex && B < this.rowIndex + this.visibleRows) {
			return true
		}
		return false
	},
	isInRange : function(B) {
		if (this.ds.bufferRange[0] < 0) {
			return false
		}
		var A = Math.min(this.ds.totalLength - 1, B + ( this.visibleRows - 1 ));
		return ( B >= this.ds.bufferRange[0] ) && ( A <= this.ds.bufferRange[1] )
	},
	getPredictedBufferIndex : function(A, B, C) {
		if (this.ds.bufferRange[0] < 0) {
			return Math.max(0, A)
		}
		if (!B) {
			if (A + this.ds.bufferSize >= this.ds.totalLength) {
				return this.ds.totalLength - this.ds.bufferSize
			}
			return Math.max(0, ( A + this.visibleRows ) - Math.round(this.ds.bufferSize / 2))
		}
		if (!C) {
			return Math.max(0, ( A - this.ds.bufferSize ) + this.visibleRows)
		}
		if (C) {
			return Math.max(0, Math.min(A, this.ds.totalLength - this.ds.bufferSize))
		}
	},
	updateLiveRows : function(H, I, E) {
		var K = this.isInRange(H);
		if (this.isBuffering) {
			if (this.isPrebuffering) {
				if (K) {
					this.replaceLiveRows(H, I)
				} else {
					this.showLoadMask(true)
				}
			}
			this.fireEvent("cursormove", this, H, Math.min(this.ds.totalLength, this.visibleRows - this.rowClipped), this.ds.totalLength);
			this.requestQueue = H;
			return
		}
		var F = this.lastIndex;
		this.lastIndex = H;
		var J = false;
		if (K && E !== true) {
			this.replaceLiveRows(H, I);
			this.fireEvent("cursormove", this, H, Math.min(this.ds.totalLength, this.visibleRows - this.rowClipped), this.ds.totalLength);
			if (this.ds.bufferRange[0] >= 0) {
				if (H > F) {
					J = true;
					var L = this.ds.totalLength;
					if (H + this.visibleRows + this.nearLimit <= this.ds.bufferRange[1]) {
						return
					}
					if (this.ds.bufferRange[1] + 1 >= L) {
						return
					}
				} else {
					if (H < F) {
						J = false;
						if (this.ds.bufferRange[0] <= 0) {
							return
						}
						if (H - this.nearLimit > this.ds.bufferRange[0]) {
							return
						}
					} else {
						return
					}
				}
			}
			this.isPrebuffering = true
		}
		this.isBuffering = true;
		var C = this.getPredictedBufferIndex(H, K, J);
		if (!K) {
			this.showLoadMask(true)
		}
		this.ds.suspendEvents();
		var G = this.ds.sortInfo;
		var D = {};
		if (this.ds.lastOptions) {
			Ext.apply(D, this.ds.lastOptions.params)
		}
		var B = this.ds.paramNames;
		D[B.start] = C;
		D[B.limit] = this.ds.bufferSize;
		if (G) {
			D[B.dir] = G.direction;
			D[B.sort] = G.field
		}
		var A = {
			forceRepaint : I,
			callback : this.liveBufferUpdate,
			scope : this,
			params : D,
			suspendLoadEvent : true
		};
		this.fireEvent("beforebuffer", this, this.ds, H, Math.min(this.ds.totalLength, this.visibleRows - this.rowClipped), this.ds.totalLength, A);
		this.ds.load(A);
		this.ds.resumeEvents()
	},
	showLoadMask : function(B) {
		if (!this.loadMask || B == this.loadMaskDisplayed) {
			return
		}
		var E = this._loadMaskAnchor.dom;
		var D = Ext.Element.data;
		var A = D(E, "mask");
		var C = D(E, "maskMsg");
		if (B) {
			A.setDisplayed(true);
			C.setDisplayed(true);
			C.center(this._loadMaskAnchor);
			if (Ext.isIE && ! ( Ext.isIE7 && Ext.isStrict ) && this._loadMaskAnchor.getStyle("height") == "auto") {
				A.setSize(undefined, this._loadMaskAnchor.getHeight())
			}
		} else {
			A.setDisplayed(false);
			C.setDisplayed(false)
		}
		this.loadMaskDisplayed = B
	},
	replaceLiveRows : function(H, G, C) {
		var B = this.ds.bufferRange, D = H - this.lastRowIndex;
		if ( ( D == 0 && G !== true ) || B[0] < 0) {
			return
		}
		var A = D > 0;
		D = Math.abs(D);
		var B = this.ds.bufferRange;
		var I = H - B[0];
		var E = Math.min(I + this.visibleRows - 1, B[1] - B[0]);
		if (D >= this.visibleRows || D == 0) {
			this.mainBody.update(this.renderRows(I, E))
		} else {
			if (A) {
				this.removeRows(0, D - 1);
				if (I + this.visibleRows - D <= B[1] - B[0]) {
					var F = this.renderRows(I + this.visibleRows - D, E);
					Ext.DomHelper.insertHtml("beforeEnd", this.mainBody.dom, F)
				}
			} else {
				this.removeRows(this.visibleRows - D, this.visibleRows - 1);
				var F = this.renderRows(I, I + D - 1);
				Ext.DomHelper.insertHtml("beforeBegin", this.mainBody.dom.firstChild, F)
			}
		}
		if (C !== false) {
			this.processRows(0, undefined, true)
		}
		this.lastRowIndex = H
	},
	adjustBufferInset : function() {
		var H = this.liveScroller.dom;
		var E = this.grid, B = E.store;
		var G = E.getGridEl();
		var K = G.getSize().width;
		var A = ( B.totalLength == this.visibleRows - this.rowClipped ) ? 0 : Math.max(0, B.totalLength - ( this.visibleRows - this.rowClipped ));
		if (A == 0) {
			this.scroller.setWidth(K);
			H.style.display = "none";
			return
		} else {
			this.scroller.setWidth(K - this.getScrollOffset());
			H.style.display = ""
		}
		var L = this.cm.getTotalWidth() + this.getScrollOffset() > K;
		var J = H.parentNode.offsetHeight + ( ( B.totalLength > 0 && L ) ? -this.horizontalScrollOffset : 0 ) - this.hdHeight;
		H.style.height = Math.max(J, this.horizontalScrollOffset * 2) + "px";
		if (this.rowHeight == -1) {
			return
		}
		var D = ( A == 0 ? 0 : J + ( A * this.rowHeight ) );
		var I = D;
		var F = this.liveScrollerInsets.length;
		if (D == 0) {
			D = 0
		} else {
			D = Math.round(D / F)
		}
		for (var C = 0; C < F; C++) {
			if (C == F - 1 && D != 0) {
				D -= ( D * 3 ) - I
			}
			this.liveScrollerInsets[C].style.height = D + "px"
		}
	},
	adjustVisibleRows : function() {
		if (this.rowHeight == -1) {
			if (this.getRows()[0]) {
				this.rowHeight = this.getRows()[0].offsetHeight;
				if (this.rowHeight <= 0) {
					this.rowHeight = -1;
					return
				}
			} else {
				return
			}
		}
		var E = this.grid, C = E.store;
		var F = E.getGridEl();
		var H = this.cm;
		var J = F.getSize();
		var B = J.width;
		var D = J.height;
		var G = B - this.getScrollOffset();
		if (H.getTotalWidth() > G) {
			D -= this.horizontalScrollOffset
		}
		D -= this.mainHd.getHeight();
		var I = C.totalLength || 0;
		var A = Math.max(1, Math.floor(D / this.rowHeight));
		this.rowClipped = 0;
		if (I > A && this.rowHeight / 3 < ( D - ( A * this.rowHeight ) )) {
			A = Math.min(A + 1, I);
			this.rowClipped = 1
		}
		if (this.visibleRows == A) {
			return
		}
		this.visibleRows = A;
		if ( ( this.isBuffering && !this.isPrebuffering ) || this.ds.bufferRange[0] < 0) {
			return
		}
		if (this.rowIndex + ( A - this.rowClipped ) > I) {
			this.rowIndex = Math.max(0, I - ( A - this.rowClipped ));
			this.lastRowIndex = this.rowIndex
		}
		this.updateLiveRows(this.rowIndex, true)
	},
	adjustScrollerPos : function(D, A) {
		if (D == 0) {
			return
		}
		var C = this.liveScroller;
		var B = C.dom;
		if (A === true) {
			C.un("scroll", this.onLiveScroll, this)
		}
		this.lastScrollPos = B.scrollTop;
		B.scrollTop += D;
		if (A === true) {
			B.scrollTop = B.scrollTop;
			C.on("scroll", this.onLiveScroll, this, {
				buffer : this.scrollDelay
			})
		}
	}
});
Ext.namespace("Ext.ux.grid.livegrid");
Ext.ux.grid.livegrid.JsonReader = function(A, B) {
	Ext.ux.grid.livegrid.JsonReader.superclass.constructor.call(this, A, B)
};
Ext.extend(Ext.ux.grid.livegrid.JsonReader, Ext.data.JsonReader, {
	buildExtractors : function() {
		if (this.ef) {
			return
		}
		var A = this.meta;
		if (A.versionProperty) {
			this.getVersion = this.createAccessor(A.versionProperty)
		}
		Ext.ux.grid.livegrid.JsonReader.superclass.buildExtractors.call(this)
	},
	readRecords : function(C) {
		if (!this.__readRecords) {
			this.__readRecords = Ext.ux.grid.livegrid.JsonReader.superclass.readRecords
		}
		var B = this.__readRecords.call(this, C);
		if (this.meta.versionProperty) {
			var A = this.getVersion(C);
			B.version = ( A === undefined || A === "" ) ? null : A
		}
		return B
	}
});
Ext.namespace("Ext.ux.grid.livegrid");
Ext.ux.grid.livegrid.RowSelectionModel = function(A) {
	this.addEvents({
		selectiondirty : true
	});
	Ext.apply(this, A);
	this.allSelected = false;
	this.excludes = [];
	this.pendingSelections = {};
	Ext.ux.grid.livegrid.RowSelectionModel.superclass.constructor.call(this)
};
Ext.extend(Ext.ux.grid.livegrid.RowSelectionModel, Ext.grid.RowSelectionModel, {
	initEvents : function() {
		Ext.ux.grid.livegrid.RowSelectionModel.superclass.initEvents.call(this);
		var C = this.grid, A = C.view, B = C.store;
		A.on("rowsinserted", this.onAdd, this);
		B.on("selectionsload", this.onSelectionsLoad, this);
		B.on("load", this.onStoreLoad, this)
	},
	onStoreLoad : function(B, A, C) {
		this.replaceSelections(A)
	},
	onRemove : function(B, D, G) {
		var A = this.getPendingSelections();
		var C = A.length;
		var F = false;
		if (D == Number.MIN_VALUE || D == Number.MAX_VALUE) {
			if (G) {
				if (this.isIdSelected(G.id) && D == Number.MIN_VALUE) {
					this.shiftSelections(this.grid.store.bufferRange[1], -1)
				}
				this.selections.remove(G);
				F = true
			}
			if (D == Number.MIN_VALUE) {
				this.clearPendingSelections(0, this.grid.store.bufferRange[0])
			} else {
				this.clearPendingSelections(this.grid.store.bufferRange[1])
			}
			if (C != 0) {
				this.fireEvent("selectiondirty", this, D, 1)
			}
		} else {
			F = this.isIdSelected(G.id);
			if (!F) {
				return
			}
			this.selections.remove(G);
			if (C != 0) {
				var H = A[0];
				var E = A[C - 1];
				if (D <= E || D <= H) {
					this.shiftSelections(D, -1);
					this.fireEvent("selectiondirty", this, D, 1)
				}
			}
		}
		if (F) {
			this.fireEvent("selectionchange", this)
		}
	},
	onAdd : function(G, E, D, B) {
		var A = this.getPendingSelections();
		var H = A.length;
		if ( ( E == Number.MIN_VALUE || E == Number.MAX_VALUE )) {
			if (E == Number.MIN_VALUE) {
				this.clearPendingSelections(0, this.grid.store.bufferRange[0]);
				this.shiftSelections(this.grid.store.bufferRange[1], B)
			} else {
				this.clearPendingSelections(this.grid.store.bufferRange[1])
			}
			if (H != 0) {
				this.fireEvent("selectiondirty", this, E, r)
			}
			return
		}
		var F = A[0];
		var C = A[H - 1];
		var I = E;
		if (I <= C || I <= F) {
			this.fireEvent("selectiondirty", this, I, B);
			this.shiftSelections(I, B)
		}
	},
	shiftSelections : function(L, C) {
		var H = 0;
		var K = 0;
		var B = {};
		var D = this.grid.store;
		var I = L - D.bufferRange[0];
		var F = 0;
		var M = this.grid.store.totalLength;
		var E = null;
		var A = this.getPendingSelections();
		var J = A.length;
		if (J == 0) {
			return
		}
		for (var G = 0; G < J; G++) {
			H = A[G];
			if (H < L) {
				continue
			}
			K = H + C;
			F = I + C;
			if (K >= M) {
				break
			}
			E = D.getAt(F);
			if (E) {
				this.selections.add(E)
			} else {
				B[K] = true
			}
		}
		this.pendingSelections = B
	},
	onSelectionsLoad : function(C, B, A) {
		this.replaceSelections(B)
	},
	hasNext : function() {
		return this.last !== false && ( this.last + 1 ) < this.grid.store.getTotalCount()
	},
	getCount : function() {
		return this.selections.length + this.getPendingSelections().length
	},
	isSelected : function(A) {
		if (typeof A == "number") {
			var B = A;
			A = this.grid.store.getAt(B);
			if (!A) {
				var D = this.getPendingSelections().indexOf(B);
				if (D != -1) {
					return true
				}
				return false
			}
		}
		var C = A;
		if (this.allSelected && !this.excludes[C.id]) {
			return true
		}
		return ( C && this.selections.key(C.id) ? true : false )
	},
	deselectRecord : function(A, C) {
		if (this.locked) {
			return
		}
		var E = this.selections.key(A.id);
		if (!E) {
			return
		}
		if (this.allSelected) {
			this.excludes[A.id] = true
		}
		var B = this.grid.store;
		var D = B.indexOfId(A.id);
		if (D == -1) {
			D = B.findInsertIndex(A);
			if (D != Number.MIN_VALUE && D != Number.MAX_VALUE) {
				D += B.bufferRange[0]
			}
		} else {
			delete this.pendingSelections[D]
		}
		if (this.last == D) {
			this.last = false
		}
		if (this.lastActive == D) {
			this.lastActive = false
		}
		this.selections.remove(A);
		if (!C) {
			this.grid.getView().onRowDeselect(D)
		}
		this.fireEvent("rowdeselect", this, D, A);
		this.fireEvent("selectionchange", this)
	},
	deselectRow : function(B, A) {
		if (this.locked) {
			return
		}
		if (this.last == B) {
			this.last = false
		}
		if (this.lastActive == B) {
			this.lastActive = false
		}
		var C = this.grid.store.getAt(B);
		delete this.pendingSelections[B];
		if (C) {
			if (this.allSelected) {
				this.excludes[C.id] = true
			}
			this.selections.remove(C)
		}
		if (!A) {
			this.grid.getView().onRowDeselect(B)
		}
		this.fireEvent("rowdeselect", this, B, C);
		this.fireEvent("selectionchange", this)
	},
	selectRow : function(B, D, A) {
		if (this.locked || B < 0 || B >= this.grid.store.getTotalCount()) {
			return
		}
		var C = this.grid.store.getAt(B);
		if (this.fireEvent("beforerowselect", this, B, D, C) !== false) {
			if (!D || this.singleSelect) {
				this.clearSelections()
			}
			if (C) {
				this.selections.add(C);
				delete this.pendingSelections[B];
				delete this.excludes[C.id]
			} else {
				this.pendingSelections[B] = true
			}
			this.last = this.lastActive = B;
			if (!A) {
				this.grid.getView().onRowSelect(B)
			}
			this.fireEvent("rowselect", this, B, C);
			this.fireEvent("selectionchange", this)
		}
	},
	clearPendingSelections : function(G, F) {
		if (F == undefined) {
			F = Number.MAX_VALUE
		}
		var B = {};
		var A = this.getPendingSelections();
		var D = A.length;
		var C = 0;
		for (var E = 0; E < D; E++) {
			C = A[E];
			if (C <= F && C >= G) {
				continue
			}
			B[C] = true
		}
		this.pendingSelections = B
	},
	replaceSelections : function(E) {
		if (!E || E.length == 0) {
			return
		}
		var D = this.grid.store;
		var F = null;
		var I = [];
		var A = this.getPendingSelections();
		var J = A.length;
		var C = this.selections;
		var H = 0;
		for (var G = 0; G < J; G++) {
			H = A[G];
			F = D.getAt(H);
			if (F) {
				C.add(F);
				I.push(F.id);
				delete this.pendingSelections[H]
			}
		}
		var B = null;
		for (G = 0, len = E.length; G < len; G++) {
			F = E[G];
			B = F.id;
			if (I.indexOf(B) == -1 && C.containsKey(B)) {
				C.add(F)
			}
		}
	},
	getState : function() {
		var C = this, B = C.selections, A = [];
		B.each(function(D) {
			A.push(D.id)
		}, this);
		return {
			selectedIds : A
		}
	},
	applyState : function(F) {
		var C = this, E = C.grid.store, D;
		if (F.selectedIds) {
			for (var B = 0, A = F.selectedIds.length; B < A; B++) {
				D = E.findExact("id", F.selectedIds[B]);
				if (D >= 0) {
					C.selectRow(E.bufferRange[0] + D, true)
				}
			}
		}
	},
	getPendingSelections : function(F) {
		var D = 1;
		var C = [];
		var B = 0;
		var G = [];
		for (var E in this.pendingSelections) {
			G.push(parseInt(E))
		}
		G.sort(function(I, H) {
			if (I > H) {
				return 1
			} else {
				if (I < H) {
					return -1
				} else {
					return 0
				}
			}
		});
		if (!F) {
			return G
		}
		var A = G.length;
		if (A == 0) {
			return []
		}
		C[B] = [G[0], G[0]];
		for (var E = 0, A = A - 1; E < A; E++) {
			if (G[E + 1] - G[E] == 1) {
				C[B][1] = G[E + 1]
			} else {
				B++;
				C[B] = [G[E + 1], G[E + 1]]
			}
		}
		return C
	},
	clearSelections : function(A) {
		if (this.locked) {
			return
		}
		if (A !== true) {
			var D = this.grid.store;
			var B = this.selections;
			var C = -1;
			B.each(function(E) {
				C = D.indexOfId(E.id);
				if (C != -1) {
					this.deselectRow(C + D.bufferRange[0])
				}
			}, this);
			B.clear();
			this.pendingSelections = {}
		} else {
			this.selections.clear();
			this.pendingSelections = {}
		}
		this.last = false;
		this.allSelected = false;
		this.excludes = []
	},
	selectRange : function(B, A, D) {
		if (this.locked) {
			return
		}
		if (!D) {
			this.clearSelections()
		}
		if (B <= A) {
			for (var C = B; C <= A; C++) {
				this.selectRow(C, true)
			}
		} else {
			for (var C = B; C >= A; C--) {
				this.selectRow(C, true)
			}
		}
	},
	isAllSelected : function() {
		return this.allSelected
	},
	selectAll : function() {
		if (this.isLocked()) {
			return
		}
		this.excludes = [];
		this.selectRange(0, this.grid.store.getTotalCount(), false);
		this.allSelected = true
	},
	getExcludes : function() {
		return this.excludes
	}
});
Ext.namespace("Ext.ux.grid.livegrid");
Ext.ux.grid.livegrid.Store = function(A) {
	A = A || {};
	A.remoteSort = true;
	this._autoLoad = A.autoLoad ? true : false;
	A.autoLoad = false;
	this.addEvents("bulkremove", "versionchange", "beforeselectionsload", "selectionsload", "insertindexfound");
	Ext.ux.grid.livegrid.Store.superclass.constructor.call(this, A);
	this.totalLength = 0;
	this.bufferRange = [-1, -1];
	this.on("clear", function() {
		this.bufferRange = [-1, -1]
	}, this);
	if (this.url && !this.selectionsProxy) {
		this.selectionsProxy = new Ext.data.HttpProxy({
			url : this.url
		})
	}
};
Ext.extend(Ext.ux.grid.livegrid.Store, Ext.data.Store, {
	wasRequestSuccessful : true,
	version : null,
	isLastSet : function(A) {
		return A == this.bufferSize && this.isAllLoaded()
	},
	isAllLoaded : function() {
		return ( this.totalLength - 1 == this.bufferRange[1] )
	},
	insert : function(F, A) {
		var C = this.isLastSet(F), I = this.isAllLoaded();
		A = [].concat(A);
		F = F >= this.bufferSize ? ( C ? F : Number.MAX_VALUE ) : F;
		if (F == Number.MIN_VALUE || F == Number.MAX_VALUE) {
			var B = A.length;
			if (F == Number.MIN_VALUE) {
				this.bufferRange[0] += B;
				this.bufferRange[1] += B
			}
			this.totalLength += B;
			this.fireEvent("add", this, A, F);
			return
		}
		var H = false;
		var G = A;
		if (!I && !C && ( A.length + F >= this.bufferSize )) {
			H = true;
			G = A.splice(0, this.bufferSize - F)
		}
		this.totalLength += G.length;
		if (this.bufferRange[0] <= -1) {
			this.bufferRange[0] = 0
		}
		if (this.bufferRange[1] < ( this.bufferSize - 1 )) {
			this.bufferRange[1] = Math.min(this.bufferRange[1] + G.length, this.bufferSize - 1)
		}
		for (var D = 0, E = G.length; D < E; D++) {
			this.data.insert(F, G[D]);
			G[D].join(this)
		}
		while (this.getCount() > this.bufferSize) {
			this.data.remove( ( C ? this.data.first() : this.data.last() ))
		}
		if (C) {
			this.bufferRange[0] += G.length;
			this.bufferRange[1] += G.length
		}
		this.fireEvent("add", this, G, F, C);
		if (H == true) {
			this.fireEvent("add", this, A, Number.MAX_VALUE, C)
		}
	},
	remove : function(B, A) {
		var C = this._getIndex(B);
		if (C < 0) {
			this.totalLength -= 1;
			if (this.pruneModifiedRecords) {
				this.modified.remove(B)
			}
			this.bufferRange[0] = Math.max(-1, this.bufferRange[0] - 1);
			this.bufferRange[1] = Math.max(-1, this.bufferRange[1] - 1);
			if (A !== true) {
				this.fireEvent("remove", this, B, C)
			}
			return C
		}
		this.bufferRange[1] = Math.max(-1, this.bufferRange[1] - 1);
		this.data.removeAt(C);
		if (this.pruneModifiedRecords) {
			this.modified.remove(B)
		}
		this.totalLength -= 1;
		if (A !== true) {
			this.fireEvent("remove", this, B, C)
		}
		return C
	},
	_getIndex : function(A) {
		var B = this.indexOfId(A.id);
		if (B < 0) {
			B = this.findInsertIndex(A)
		}
		return B
	},
	bulkRemove : function(B) {
		var G = null;
		var E = [];
		var D = 0;
		var A = B.length;
		var F = [];
		for (var C = 0; C < A; C++) {
			G = B[C];
			F[G.id] = this._getIndex(G)
		}
		for (var C = 0; C < A; C++) {
			G = B[C];
			this.remove(G, true);
			E.push([G, F[G.id]])
		}
		this.fireEvent("bulkremove", this, E)
	},
	removeAll : function() {
		this.totalLength = 0;
		this.bufferRange = [-1, -1];
		this.data.clear();
		if (this.pruneModifiedRecords) {
			this.modified = []
		}
		this.fireEvent("clear", this)
	},
	loadRanges : function(B) {
		var A = B.length;
		var D = this.paramNames;
		if (A > 0 && !this.selectionsProxy.activeRequest[Ext.data.Api.actions.read] && this.fireEvent("beforeselectionsload", this, B) !== false) {
			var F = this.lastOptions.params;
			var G = {};
			G.ranges = Ext.encode(B);
			if (F) {
				if (F[D.sort]) {
					G[D.sort] = F[D.sort]
				}
				if (F[D.dir]) {
					G[D.dir] = F[D.dir]
				}
			}
			var C = {};
			for (var E in this.lastOptions) {
				C.i = this.lastOptions.i
			}
			C.ranges = G.ranges;
			this.selectionsProxy.doRequest(Ext.data.Api.actions.read, null, C, this.reader, this.selectionsLoaded, this, C)
		}
	},
	loadSelections : function(A) {
		if (A.length == 0) {
			return
		}
		this.loadRanges(A)
	},
	selectionsLoaded : function(F, B, E) {
		if (this.checkVersionChange(F, B, E) !== false) {
			var D = F.records;
			for (var C = 0, A = D.length; C < A; C++) {
				D[C].join(this)
			}
			this.fireEvent("selectionsload", this, F.records, Ext.decode(B.ranges))
		} else {
			this.fireEvent("selectionsload", this, [], Ext.decode(B.ranges))
		}
	},
	checkVersionChange : function(D, B, C) {
		if (D && C !== false) {
			if (D.version !== undefined) {
				var A = this.version;
				this.version = D.version;
				if (this.version !== A) {
					return this.fireEvent("versionchange", this, A, this.version)
				}
			}
		}
	},
	findInsertIndex : function(A) {
		this.remoteSort = false;
		var B = Ext.ux.grid.livegrid.Store.superclass.findInsertIndex.call(this, A);
		this.remoteSort = true;
		if (this.bufferRange[0] <= 0 && B == 0) {
		} else {
			if (this.bufferRange[0] > 0 && B == 0) {
				B = Number.MIN_VALUE
			} else {
				if (B >= this.bufferSize) {
					B = Number.MAX_VALUE
				}
			}
		}
		var C = {
			insertIndex : B
		};
		this.fireEvent("insertindexfound", this, C);
		return C.insertIndex
	},
	sortData : function(B, C) {
		var A = this.snapshot;
		this.snapshot = false;
		Ext.ux.grid.livegrid.Store.superclass.sortData.apply(this, arguments);
		this.snapshot = A
	},
	onMetaChange : function(B, A, C) {
		this.version = null;
		Ext.ux.grid.livegrid.Store.superclass.onMetaChange.call(this, B, A, C)
	},
	loadRecords : function(D, B, C) {
		this.checkVersionChange(D, B, C);
		if (!D) {
			this.wasRequestSuccessful = false;
			this.bufferRange = [-1, -1]
		} else {
			this.wasRequestSuccessful = true;
			var A = this.paramNames;
			this.bufferRange = [B.params.start, Math.max(0, Math.min( ( B.params[A.start] + B.params[A.limit] ) - 1, D.totalRecords - 1))]
		}
		if (B.suspendLoadEvent === true) {
			this.suspendEvents()
		}
		Ext.ux.grid.livegrid.Store.superclass.loadRecords.call(this, D, B, C);
		if (B.suspendLoadEvent === true) {
			this.resumeEvents()
		}
	},
	getAt : function(A) {
		if (this.bufferRange[0] == -1) {
			return undefined
		}
		var B = A - this.bufferRange[0];
		return this.data.itemAt(B)
	},
	wasLastRequestSuccessful : function() {
		return this.wasRequestSuccessful
	},
	clearFilter : function() {
	},
	isFiltered : function() {
	},
	collect : function() {
	},
	createFilterFn : function() {
	},
	sum : function() {
	},
	filter : function() {
	},
	filterBy : function() {
	},
	query : function() {
	},
	queryBy : function() {
	},
	find : function() {
	},
	findBy : function() {
	}
});
Ext.namespace("Ext.ux.grid.livegrid");
Ext.ux.grid.livegrid.CheckboxSelectionModel = Ext.extend(Ext.ux.grid.livegrid.RowSelectionModel, {
	width : 20,
	menuDisabled : true,
	sortable : false,
	fixed : true,
	dataIndex : "",
	id : "checker",
	headerCheckbox : null,
	markAll : false,
	constructor : function() {
		if (!this.header) {
			this.header = Ext.grid.CheckboxSelectionModel.prototype.header
		}
		this.sortable = false;
		Ext.ux.grid.livegrid.CheckboxSelectionModel.superclass.constructor.call(this)
	},
	initEvents : function() {
		Ext.ux.grid.livegrid.CheckboxSelectionModel.superclass.initEvents.call(this);
		this.grid.view.on("reset", function(A, B) {
			this.headerCheckbox = new Ext.Element(A.getHeaderCell(this.grid.getColumnModel().getIndexById(this.id)).firstChild);
			if (this.markAll && B === false) {
				this.headerCheckbox.addClass("x-grid3-hd-checker-on")
			}
		}, this);
		Ext.grid.CheckboxSelectionModel.prototype.initEvents.call(this)
	},
	onMouseDown : function(B, A) {
		if (B.button === 0 && A.className == "x-grid3-row-checker") {
			B.stopEvent();
			var C = B.getTarget(".x-grid3-row");
			if (C) {
				if (this.headerCheckbox) {
					this.markAll = false;
					this.headerCheckbox.removeClass("x-grid3-hd-checker-on")
				}
			}
		}
		return Ext.grid.CheckboxSelectionModel.prototype.onMouseDown.call(this, B, A)
	},
	onHdMouseDown : function(B, A) {
		if (A.className == "x-grid3-hd-checker" && !this.headerCheckbox) {
			this.headerCheckbox = new Ext.Element(A.parentNode)
		}
		return Ext.grid.CheckboxSelectionModel.prototype.onHdMouseDown.call(this, B, A)
	},
	renderer : function(B, C, A) {
		return Ext.grid.CheckboxSelectionModel.prototype.renderer.call(this, B, C, A)
	},
	handleMouseDown : function(A, C, B) {
		if (B.shiftKey) {
			return
		}
		this.markAll = false;
		if (this.headerCheckbox) {
			this.headerCheckbox.removeClass("x-grid3-hd-checker-on")
		}
		Ext.ux.grid.livegrid.CheckboxSelectionModel.superclass.handleMouseDown.call(this, A, C, B)
	},
	clearSelections : function(A) {
		if (this.isLocked()) {
			return
		}
		this.markAll = false;
		if (this.headerCheckbox) {
			this.headerCheckbox.removeClass("x-grid3-hd-checker-on")
		}
		Ext.ux.grid.livegrid.CheckboxSelectionModel.superclass.clearSelections.call(this, A)
	},
	selectAll : function() {
		Ext.ux.grid.livegrid.CheckboxSelectionModel.superclass.selectAll.call(this);
		this.markAll = true;
		if (this.headerCheckbox) {
			this.headerCheckbox.addClass("x-grid3-hd-checker-on")
		}
	}
});
Ext.namespace("Ext.ux.grid.livegrid");
Ext.ux.grid.livegrid.Toolbar = Ext.extend(Ext.Toolbar, {
	displayMsg : "Displaying {0} - {1} of {2}",
	bufferFailedMsg : "Could not load data ({0})",
	emptyMsg : "No data to display",
	beforeloadMsg : "Loading...",
	loadFailedMsg : "Loading failed.",
	refreshText : "Refresh",
	lastInfo : null,
	initComponent : function() {
		Ext.ux.grid.livegrid.Toolbar.superclass.initComponent.call(this);
		if (this.grid) {
			this.view = this.grid.getView()
		}
		var A = this;
		this.view.init = this.view.init.createSequence(function() {
			A.bind(this)
		}, this.view)
	},
	updateInfo : function(E, D, A, B) {
		if (!this.displayEl) {
			return
		}
		if (B) {
			switch (B) {
				case "beforeload" :
					this.displayEl.update(this.beforeloadMsg);
					return
			}
		}
		if (A == 0 && this.view.ds.bufferRange[0] < 0) {
			if (this.lastInfo && this.lastInfo.totalLength) {
				this.displayEl.update(String.format(this.bufferFailedMsg, String.format(this.displayMsg, E + 1, E + this.view.visibleRows, this.lastInfo.totalLength)));
				return
			}
			this.displayEl.update(this.loadFailedMsg);
			return
		}
		var C = A == 0 ? this.emptyMsg : String.format(this.displayMsg, E + 1, E + D, A);
		this.displayEl.update(C)
	},
	unbind : function(A) {
		var B;
		var C;
		if (A instanceof Ext.grid.GridView) {
			C = A
		} else {
			C = A.getView()
		}
		B = A.ds;
		B.un("loadexception", this.enableLoading, this);
		B.un("beforeload", this.disableLoading, this);
		B.un("load", this.enableLoading, this);
		B.un("load", this.onStoreLoad, this);
		B.un("beforeload", this.onStoreBeforeLoad, this);
		C.un("rowremoved", this.onRowRemoved, this);
		C.un("rowsinserted", this.onRowsInserted, this);
		C.un("beforebuffer", this.beforeBuffer, this);
		C.un("cursormove", this.onCursorMove, this);
		C.un("buffer", this.onBuffer, this);
		C.un("bufferfailure", this.enableLoading, this);
		C.un("bufferfailure", this.onBufferFailure, this);
		this.view = undefined
	},
	bind : function(A) {
		this.view = A;
		var B = A.ds;
		B.on("loadexception", this.enableLoading, this);
		B.on("beforeload", this.disableLoading, this);
		B.on("load", this.enableLoading, this);
		B.on("load", this.onStoreLoad, this);
		B.on("beforeload", this.onStoreBeforeLoad, this);
		A.on("rowremoved", this.onRowRemoved, this);
		A.on("rowsinserted", this.onRowsInserted, this);
		A.on("beforebuffer", this.beforeBuffer, this);
		A.on("cursormove", this.onCursorMove, this);
		A.on("buffer", this.onBuffer, this);
		A.on("bufferfailure", this.enableLoading, this);
		A.on("bufferfailure", this.onBufferFailure, this)
	},
	onBufferFailure : function() {
		this.updateInfo(this.view.rowIndex, this.view.visibleRows, 0)
	},
	onStoreBeforeLoad : function() {
		this.lastInfo = null;
		this.updateInfo(undefined, undefined, undefined, "beforeload")
	},
	onStoreLoad : function() {
		this.lastInfo = {
			totalLength : this.view.ds.totalLength
		}
	},
	enableLoading : function() {
		this.loading.setDisabled(false)
	},
	disableLoading : function() {
		this.loading.setDisabled(true)
	},
	onCursorMove : function(B, D, C, A) {
		this.updateInfo(D, C, A)
	},
	onRowsInserted : function(B, C, A) {
		this.updateInfo(B.rowIndex, Math.min(B.ds.totalLength, B.visibleRows - B.rowClipped), B.ds.totalLength)
	},
	onRowRemoved : function(B, C, A) {
		this.updateInfo(B.rowIndex, Math.min(B.ds.totalLength, B.visibleRows - B.rowClipped), B.ds.totalLength)
	},
	beforeBuffer : function(B, C, F, E, A, D) {
		this.loading.disable();
		this.updateInfo(F, E, A)
	},
	onBuffer : function(B, C, E, D, A) {
		if (A > 0 && this.view.ds.bufferRange[0] >= 0) {
			this.lastInfo = {
				totalLength : A
			}
		}
		this.loading.enable();
		this.updateInfo(E, D, A)
	},
	onClick : function(A) {
		switch (A) {
			case "refresh" :
				if (this.view.reset(true)) {
					this.loading.disable()
				} else {
					this.loading.enable()
				}
				break
		}
	},
	onRender : function(B, A) {
		Ext.PagingToolbar.superclass.onRender.call(this, B, A);
		this.loading = new Ext.Toolbar.Button({
			tooltip : this.refreshText,
			iconCls : "x-tbar-loading",
			handler : this.onClick.createDelegate(this, ["refresh"])
		});
		this.addButton(this.loading);
		this.addSeparator();
		if (this.displayInfo) {
			this.displayEl = Ext.fly(this.el.dom).createChild({
				cls : "x-paging-info"
			})
		}
	}
});
Ext.namespace("Ext.ux.grid.livegrid");
Ext.ux.grid.livegrid.DragZone = function(B, A) {
	Ext.ux.grid.livegrid.DragZone.superclass.constructor.call(this, B, A);
	this.view.ds.on("beforeselectionsload", this._onBeforeSelectionsLoad, this);
	this.view.ds.on("selectionsload", this._onSelectionsLoad, this)
};
Ext.extend(Ext.ux.grid.livegrid.DragZone, Ext.grid.GridDragZone, {
	isDropValid : true,
	onInitDrag : function(A) {
		this.view.ds.loadSelections(this.grid.selModel.getPendingSelections(true));
		Ext.ux.grid.livegrid.DragZone.superclass.onInitDrag.call(this, A)
	},
	_onBeforeSelectionsLoad : function() {
		this.isDropValid = false;
		Ext.fly(this.proxy.el.dom.firstChild).addClass("ext-ux-livegrid-drop-waiting")
	},
	_onSelectionsLoad : function() {
		this.isDropValid = true;
		this.ddel.innerHTML = this.grid.getDragDropText();
		Ext.fly(this.proxy.el.dom.firstChild).removeClass("ext-ux-livegrid-drop-waiting")
	}
});
Ext.namespace("Ext.ux.grid.livegrid");
Ext.ux.grid.livegrid.EditorGridPanel = Ext.extend(Ext.grid.EditorGridPanel, {
	initEvents : function() {
		Ext.ux.grid.livegrid.EditorGridPanel.superclass.initEvents.call(this);
		this.view.on("cursormove", this.stopEditing, this, [true])
	},
	startEditing : function(B, A) {
		this.stopEditing();
		if (this.colModel.isCellEditable(A, B)) {
			this.view.ensureVisible(B, A, true);
			if (!this.store.getAt(B)) {
				return
			}
		}
		return Ext.ux.grid.livegrid.EditorGridPanel.superclass.startEditing.call(this, B, A)
	},
	walkCells : function(E, A, D, C, B) {
		return Ext.ux.grid.livegrid.GridPanel.prototype.walkCells.call(this, E, A, D, C, B)
	},
	onRender : function(B, A) {
		return Ext.ux.grid.livegrid.GridPanel.prototype.onRender.call(this, B, A)
	},
	initComponent : function() {
		if (this.cls) {
			this.cls += " ext-ux-livegrid"
		} else {
			this.cls = "ext-ux-livegrid"
		}
		return Ext.ux.grid.livegrid.EditorGridPanel.superclass.initComponent.call(this)
	}
});