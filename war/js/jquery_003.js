(function(){jQuery.widget("ui.ncbilocalnav",jQuery.ui.ncbimenu,{_create:function(){this.options.isSubMenuLimited=true;jQuery.ui.ncbimenu.prototype._create.apply(this,arguments)},_addClasses:function(){this.element.addClass("ui-ncbilocalnav");jQuery.ui.ncbimenu.prototype._addClasses.apply(this,arguments)},_destroyClasses:function(){this.element.removeClass("ui-ncbilocalnav");jQuery.ui.ncbimenu.prototype._destroyClasses.apply(this,arguments)}})})();
