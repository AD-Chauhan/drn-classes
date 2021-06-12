(function ($) {

  
  function isCollapsable(arg) {
    return arg instanceof Object && Object.keys(arg).length > 0;
  }

  function isUrl(string) {
    var regexp = /^(ftp|http|https):\/\/(\w+:{0,1}\w*@)?(\S+)(:[0-9]+)?(\/|\/([\w#!:.?+=&%@!\-\/]))?/
    return regexp.test(string);
  }

  function json2html(json, options) {
    var html = '';
    if (typeof json === 'string') {
      json = json.replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;');
      if (isUrl(json))
        html += '<a href="' + json + '" class="json-string">' + json + '</a>';
      else
        html += '<span class="json-string">"' + json + '"</span>';
    }
    else if (typeof json === 'number') {
      html += '<span class="json-literal">' + json + '</span>';
    }
    else if (typeof json === 'boolean') {
      html += '<span class="json-literal">' + json + '</span>';
    }
    else if (json === null) {
      html += '<span class="json-literal">null</span>';
    }
    else if (json instanceof Array) {
      if (json.length > 0) {
        html += '[<ol class="json-array">';
        for (var i = 0; i < json.length; ++i) {
          html += '<li data-key-type="array" data-key="' + i + '">'
          html += json2html(json[i], options);
          if (i < json.length - 1) {
            html += ',';
          }
          html += '</li>';
        }
        html += '</ol>]';
      }
      else {
        html += '[]';
      }
    }
    else if (typeof json === 'object') {
      var key_count = Object.keys(json).length;
      if (key_count > 0) {
        html += '{<ul class="json-dict">';
        for (var key in json) {
          if (json.hasOwnProperty(key)) {
            html += '<li data-key-type="object" data-key="' + key + '">';
            var keyRepr = options.outputWithQuotes ?
              '<span class="json-string">"' + key + '"</span>' : key;
            html += keyRepr;
            
            html += ': ' + json2html(json[key], options);
            if (--key_count > 0)
              html += ',';
            html += '</li>';
          }
        }
        html += '</ul>}';
      }
      else {
        html += '{}';
      }
    }
    return html;
  }


  $.fn.jsonPathPicker = function (json, options) {
    options = options || {};
    options.pathQuotesType = options.pathQuotesType !== undefined ? options.pathQuotesType : 'single';
    return this.each(function () {
      var html = json2html(json, options)
      $(this).html(html);
      $(this).off('click');
     
    });
  };
})(jQuery);
