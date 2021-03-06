// Generated by CoffeeScript 1.7.1

/*
 @preserve jQuery.PrettyTextDiff 1.0.4
 See https://github.com/arnab/jQuery.PrettyTextDiff/
 */

(function() {
    var $;

    $ = jQuery;

    $.fn.extend({
        prettyTextDiff: function(options) {
            var dmp, settings;
            settings = {
                originalContainer: ".original",
                changedContainer: ".changed",
                diffContainer: ".diff",
                cleanup: true,
                debug: false
            };
            settings = $.extend(settings, options);
            $.fn.prettyTextDiff.debug("Options: ", settings, settings);
            dmp = new diff_match_patch();
            return this.each(function() {
                var changed, diff_as_html, diffs, original;
                if (settings.originalContent && settings.changedContent) {
                    original = $('<div />').html(settings.originalContent).html();
                    changed = $('<div />').html(settings.changedContent).html();
                } else {
                    original = $(settings.originalContainer, this).html();
                    changed = $(settings.changedContainer, this).html();
                }
                changed=changed.replace(/<[^>]+>/g,"");
                $.fn.prettyTextDiff.debug("Original text found: ", original, settings);
                $.fn.prettyTextDiff.debug("Changed  text found: ", changed, settings);
                diffs = dmp.diff_main(original, changed);
                if (settings.cleanup) {
                    dmp.diff_cleanupSemantic(diffs);
                }
                $.fn.prettyTextDiff.debug("Diffs: ", diffs, settings);
                diff_as_html = $.map(diffs, function(diff) {
                    return $.fn.prettyTextDiff.createHTML(diff);
                });
                $(settings.diffContainer, this).html(diff_as_html.join(''));
                return this;
            });
        }
    });

    $.fn.prettyTextDiff.debug = function(message, object, settings) {
        if (settings.debug) {
            return console.log(message, object);
        }
    };

    $.fn.prettyTextDiff.keys = 0;
    
    $.fn.prettyTextDiff.createHTML = function(diff) {    	
        var data, html, operation, pattern_amp, pattern_gt, pattern_lt, pattern_para, arrys;        
        html = [];
        pattern_amp = /&/g;
        pattern_lt = /</g;
        pattern_gt = />/g;
        pattern_para = /\n/g;
        operation = diff[0], data = diff[1];
        arrys = data.replace(pattern_amp, '&amp;').replace(pattern_lt, '*&lt;').replace(pattern_gt, '&gt;*').replace(pattern_para, '<br>');
        var a = arrys.split("*");
        for(var i in a){
        	var st = a[i].replace(/(^\s*)|(\s*$)/g,'').substring(0,4);
        	if( st == "&lt;" ){
        		$.fn.prettyTextDiff.keys = 1;
        	}
        	if( st == "&gt;" || a[i].substring( a[i].length-4 ) == "&gt;" ){
        		$.fn.prettyTextDiff.keys = 0;
        	}
        	if( st == "&lt;" || st == "&gt;" || st == "<br>" || a[i] == "" || $.fn.prettyTextDiff.keys == 1){
        		
        	}else{        		
        		switch (operation) {
	                case DIFF_INSERT: 
	                	a[i] = '<ins>' + a[i] + '</ins>';
	                	break;
	                case DIFF_DELETE:
	                	a[i] =  '<del>' + a[i] + '</del>';
	                	break;
	                case DIFF_EQUAL:
	                	a[i] =  '<span>' + a[i] + '</span>';
	                	break;
	            }
        	}
        } 
        return a.join('');
    };

}).call(this);
