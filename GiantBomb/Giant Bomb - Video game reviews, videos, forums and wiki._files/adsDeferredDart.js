(function(aq){var i="ad-service-client";var aI="view-guid-meta";var E="content";var M="vguid";var K="companion_ad",Q="leader_plus_top",X="leader_top",k="omnibar_top",c="nav_logo_top",P="skin_top",ad="mpu_top",aJ="ytembed_top";var F="skin-yes",J="skin-no",ah="has-ads",W="has-nav-sponsor",ae="has-omnibar",aK="mapped-ad-blank",U="skinadaptive";var ax="-wrap";var q="data-ad-event";var aU=true,ao,at=[],au,z,ar=aq.siteAdsLogger||[],y=aq.document,aa=false,n,a=false,az="page_load",af,aH=az,h={};var aD=function(aW){return ab(aW+ax)};var aR=function(){var aW,aZ,a0,a3=P,aY=ab(a3),a1=aD(a3),a4,a2,aX=false;if(!!a1){a4=a1.previousElementSibling;a2=a1.nextElementSibling}aW=X;aZ=ab(aW);if(!aZ){aW=Q;aZ=ab(aW)}a0=aD(aW);if(!!a1&&!!a0&&((a2===a0)||(a4===a0))){aX=true}return{skinDiv:aY,skinDivWrap:a1,skinNextSibling:a2,leaderDiv:aZ,leaderDivWrap:a0,isAdjacent:aX}};var e=(function(){var aW=false;return function(){if(true===aW){return}var a0=S();if(true===a0.rendered[P]){var a1=aR(),aY=a1.leaderDivWrap,aX=a1.skinDivWrap,aZ=a1.skinNextSibling,a2;ar.push("Processing skin render");if(!!aX){a2=aX.parentElement}if(!!a2&&!!aY&&false===a1.isAdjacent){ar.push("Move leader after skin");aQ(a1.leaderDiv);a2.insertBefore(aY,aZ)}aW=true}if(!!a0.adSkinId&&a0.loaded.length===1){ar.push("Skin loaded, refresh remaining ads");T();p()}}})();var al=(function(){var aX=false,aW=ad;return function(){var a1=S();if(true===aX){return}if(false===a1.rendered[aW]){var a0=aD(aW),a2=a0.parentElement,aZ,aY,a3;a2=a0.parentElement;if(!!a2&&!!a2.tagName&&"li"===a2.tagName.toLowerCase()){aZ=a2.parentElement}if(!!aZ&&!!aZ.getAttribute){aY=aZ.getAttribute("data-no-ads-class");a3=aZ.getAttribute("data-has-ads-class");aL(aZ,a3,false);aL(aZ,aY,true);aZ.removeChild(a2)}aX=true}}})();var f=(function(){var aY="has-ytembed has-ytembed-rendered",aX="no-ytembed",aZ=".ytembed-wrapper",aW;return function(){var a1=S(),a4=a1.rendered[aJ],a5=$(aD(aJ)),a3,a0,a2;if(undefined===aW){aW=a5.parents(aZ)}if(!aW||0===aW.length){return}a3=aW.data("ytembed-class")||aY;a0=aW.data("ytembed-blank-class")||aX;if(!a4){aW.removeClass(a3);aW.addClass(a0)}else{aW.addClass(a3);aW.removeClass(a0)}}})();var r=function(aX){var aW=aX.divId,aY;switch(aW){case ad:aY=al;break;case aJ:aY=f;break}if(aY){ar.push("Ad render processed for ["+aW+"]");aY()}};var aF=function(aW){return(aW.indexOf("skin")>=0)};var V=function(aY,aW){var aX=aD(aY);if(!!aX){aL(aX,aK,aW)}};var j=function(aY,aX){var aW=u(),a0,aZ;if(!!aY){ar.push("skinless");aL(aW,J,true);aL(aW,F,false);if(!!af){a0=af}}else{aL(aW,F,true);aL(aW,J,false);if(!aX||"null"===aX){aX=U}if(aX!==af){a0=af;af=aZ=aX}ar.push("skinned: "+aX)}if(!!a0){aL(aW,a0,false)}if(!!aZ){ar.push("Setting skin type to "+aZ);aL(aW,aZ,true)}e()};var H="page-event-ad-settings",l=function(){var aX=aq.jQuery,aW=[];if(!!aX){aX("."+H).each(function(){var aY=aX(this),aZ=null;if(aY.length>0){try{aZ=aX.parseJSON(aY.attr("content"))}catch(a0){aZ=null}}if(null!==aZ){aW.push(aZ)}})}return aW};var ai=false;var R=function(aX,aW,aY){if(!aW||!aY){return}aH=aW;ai=true};var aE=function(){var aW=aq.jQuery;if(!!aW){aW(y).on({update_page_event:function(aY,aX){R(aY,aX,aH!==aX)},render_page_event:R,on_page_event:function(aY,aX){if(!aX){return}p(aX)},remove_page_event:function(aY,aX){if(!aX){return}B(aX);aH=Y}})}};var ab=function(aW){return y.getElementById(aW)};var u=function(){if(!n){n=y.body}return n};var aw=function(aW){try{return aq.JSON.parse(aW)}catch(aX){return null}};var aP=function(aY,aW,aX){try{return aq.JSON.stringify(aY,aW,aX)}catch(aZ){return null}};var aL=function(a3,aZ,aX){var aW=a3.className,a1=" "+aZ,aY,a0=0,a2=0;if((aX===true)&&(aV(a3,aZ)===false)){if(aW.length>0){aY=aW+a1}else{aY=aZ}}else{if((aX===false)&&(aV(a3,aZ)===true)){if(aW.length>0){a0=aW.indexOf(a1);if(a0===-1){a0=aW.indexOf(aZ)}a2=a0+aZ.length+1;aY=aW.substr(0,a0)+aW.substr(a2)}}}if(aY!==undefined){a3.className=aY}};var aV=function(aZ,aX){var aW=aZ.className,aY=false;if(!!aW){aY=(aW.indexOf(aX)>=0)}return aY};var s=[],Y=az;var x=function(){var aY=ab(aI),aX=E,aW;try{if(!!aY&&aY.hasAttribute(aX)){aW=aY.getAttribute(aX)}}catch(aZ){}return aW};var aM=function(aX){var aW="ad-settings";if(!!aX&&aX!==Y){aW=aX+"-"+aW}return ab(aW)};var av=function(aZ){var aW="content",aY=s[aZ],aX;aZ=aZ||aH||Y;if(aY===undefined){aX=aM(aZ);if(!aX){aY=null}else{if(aX.hasAttribute(aW)){aW=aX.getAttribute(aW);aY=aw(aW);if(aY.target_params.hasOwnProperty("session")){if(aY.target_params.session==""){aY.target_params.session=$.cookie("AD_SESSION")}}}else{aY=null}}s[aZ]=aY}return aY};var C=function(aX,aW){if(!!aX&&!!aW){s[aX]=aW}};var t=function(a4,aZ){var a0=S(),a3=a4.divId,a1=a4.isBlank,aY=a4.isSkin,a5=a4.skinType,aX=u(),aW=false,a2="";if(true===aZ){a2="Ad render detected > "}else{a2="Callback from creative > "}ar.push(a2+"renderAdCallback: "+aP(a4));if(!a3&&true===aY){a3=P}a0.rendered[a3]=!a1;a0.loaded.push(a3);if(!!a1){V(a3,true);if(!!aY){j(true)}}else{V(a3,false);if(!!aY){j(false,a5)}switch(a3){case c:ar.push("Nav logo ad exists");aW=W;break;case k:ar.push("Omnibar ad exists");aW=ae;break}if(aW){aL(aX,aW,true)}aL(aX,ah,true)}r(a4)};aq.renderAdCallback=t;var D=function(aX,aW){var aZ,aY;if(!aX||!aX.setTargeting||!aW){return}for(aZ in aW){if(aW.hasOwnProperty(aZ)){aY='("'+aZ+'", "'+aW[aZ]+'")';try{aX.setTargeting(aZ,aW[aZ].toString());ar.push("-> setTargeting"+aY)}catch(a0){ar.push("error","setTargeting failed for "+aY+". Please make sure targeting key and value are strings.")}}}};var o=function(a1,a2,aX){var a3,aY,a0,aW,aZ={adId:a2};if(aU){aW=ab(a2);if(!aW){ar.push("IGNORE slot ["+a2+"]: adDiv not found");return false}aZ.adDiv=aW;if(aW.hasAttribute(q)){a0=aW.getAttribute(q)}}if(!a0){a0=az}aZ.adEvent=a0;if(!!aX.outOfPage){ar.push("DEFINE out of page slot ["+a2+"]");a3=ao.defineOutOfPageSlot(a1,a2).addService(z)}else{ar.push("DEFINE slot ["+a2+"] with sizes "+aP(aX.size));a3=ao.defineSlot(a1,aX.size,a2);if(K===a2){ar.push("-> Adding companionAds service");a3.addService(ao.companionAds())}a3.addService(z);aY=aX.target;if(!!aY){ar.push("-> Set slot ["+a2+"] targeting:");D(a3,aY)}}aZ.adSlot=a3;ap(aZ);return true};var b=function(a1){var a4=av(a1),aX=av(),a2=a4.unit_name||aX.unit_name,a3=a4.page_event_name,aZ,aY,aW="Defining ads for ",a0=false;if(!!a3){aW+="["+a3+"] page event with "}aY=a4.mapped_units;if(!!aY){ar.push(aW+"unitName: ["+a2+"]");for(aZ in aY){if(aY.hasOwnProperty(aZ)){a0=o(a2,aZ,aY[aZ],a3)||a0}}return a0}return false};var Z=function(){var aY=l(),aZ,a0,aX,aW=false;if(!!aY&&0<aY.length){for(aX=0;aX<aY.length;aX++){aZ=aY[aX];a0=aZ.page_event_name;if(!!a0){C(a0,aZ);aW=b(a0)||aW}}}if(true===aW){aE()}return aW};var ak=function(aZ){var aY=av(aZ),aX=aY.target_params,aW=x();if(!!aX){if(!!aW){aX.vguid=aW}ar.push("SET PAGE LEVEL TARGETING:");D(z,aX)}else{ar.push("There are no page targeting key/value pairs")}};var O=function(){var aY=av(),aW=!!aY.disable_initial_load,aX=false;z=ao.pubads();aX=b()||aX;if(true===aU){aX=Z()||aX}if(false===aX){ar.push("No ads on the page. Quitting.");return}ak();if(aY.enable_collapse_empty_divs){ar.push("Enable collapse empty divs");z.collapseEmptyDivs(true)}if(true===aY.single_request){ar.push("Enable single request");z.enableSingleRequest()}if(false===aU){ar.push("Enable sync rendering");z.enableSyncRendering()}if(true===aW){ar.push("Disable initial load");z.disableInitialLoad()}ar.push("Enable services");ao.enableServices();$(document).trigger("ads_initialized");if(true===aU&&true===aW){ar.push("Refresh Ads");p()}N()};var ap=function(aX){var aW=aX.adId,aZ=aX.adEvent,aY;if(!h[aZ]){h[aZ]={adSkinId:null,adIds:[],map:{},loadDetected:{},rendered:{},loaded:[],pending:[]}}delete aX.adId;h[aZ].map[aW]=aX;if(!!aU&&aF(aW)){aY=aR();if(true===aY.isAdjacent){h[aZ].adIds.push(aW)}else{h[aZ].adSkinId=aW}}else{h[aZ].adIds.push(aW)}};var S=function(aW){if(!aW){aW=aH}return h[aW]};var m=function(aY){var aX=S(aY),aW=aX.adSkinId,aZ;if(!!aW&&undefined===aX.rendered[aW]){aZ=[aW]}if(!aZ){aZ=aX.adIds.slice(0)}return aZ};var aO=function(aZ){var aX=S(aZ),a0=m(aZ),aY=[],aW;for(aW=0;aW<a0.length;aW++){aY.push(aX.map[a0[aW]].adDiv)}return aY};var aC=function(aY){var aX=S(aY),a0=m(aY),aZ=[],aW;for(aW=0;aW<a0.length;aW++){aZ.push(aX.map[a0[aW]].adSlot)}return aZ};var g=2500,aT=200,L=0,ac=30000,G=false,an=false,aA=false,I=null,aS=null,v=null,aG=0,am=function(aY){var aW=S(aY),a0=aW.adSkinId,aZ=aW.loaded.length,aX=false;if(!!a0){if(aZ>1){aX=true}}else{if(aZ>0){aX=true}}if(true===aX){aW.rendered={};aW.loadDetected={};aW.loaded=[];aW.pending=[]}},aB=function(){var aW=new Date(),a9=aW.getTime(),aZ=S(),a4=aO(),aY=a4.length,a8=[],a2,a5,a3,a6,a0,aX=false,a7=false,a1=0;aA=true;if(null===I){am();L=g;if(!!aZ.adSkinId){if(0===aZ.loaded.length){L=aT}}aG=0;I=a9;aS=a9+ac;an=false;aN();return}a2=aZ.rendered;a5=aZ.loadDetected;ar.push("Checking for blank ads ("+(++aG)+")");while(a1<aY){a3=a4.shift();a6=a3.id;a7=false;aX=aF(a6);if(undefined===a2[a6]){if(undefined===a5[a6]){if(0<a3.innerHTML.indexOf("iframe")){ar.push("Ad load detected for ["+a6+"]");a5[a6]=1}a8.push(a6)}else{ar.push("Checking if ["+a6+"] loaded as blank");if("none"===a3.style.display){a0=true}else{a0=false}if(false===aX){a7={divId:a6,isBlank:a0};if(true===aX){a7.isSkin=true}}else{ar.push("Relying on skin to fire renderAdCallback")}if(false!==a7){t(a7,true)}}}a1++}aZ.pending=a8;if(0===a8.length){ar.push("Auto detect has verified all display ads.");an=true}else{ar.push("Ads not verified yet:\n",a8.join(", "))}if((false===an)&&a9>=aS){if(0<a8.length){ar.push("Polling reached time limit ("+ac+" milliseconds) before we verified all ads.")}an=true}if(true===an){T()}else{aN(true)}},T=function(){if(null!==I){ar.push("Stop polling for blank display ads");I=null;clearTimeout(v);v=null;aA=false}},aN=function(aW){ar.push("Check for blank ads "+(aW?"again ":"")+"in "+L+" milliseconds");v=setTimeout(aB,L)};var d=function(aW){ar.push("DISPLAY ["+aW+"] ad");ao.cmd.push(function(){ao.display(aW)})};var aQ=function(aW){if(!!aW){if(0<aW.innerHTML.indexOf("iframe")){ar.push("RESET adDiv ["+aW.id+"]");aW.style.display="";aW.innerHTML=""}}};var B=function(aZ){var aY=aO(aZ),aW,aX;if(!aY||aY.length<1){return}for(aX=0;aX<aY.length;aX++){aW=aY[aX];aQ(aW)}};var ay=function(){var aW=x(),aX={};aX[M]=aW;ar.push("UPDATE PAGE LEVEL TARGETING:");D(z,aX)};var p=function(aW){ao.cmd.push(function(){var aY=m(aW),aX=aC(aW);B(aW);if(ai){ay()}ar.push("REFRESH ad slots: ["+aY.join(", ")+"]");z.refresh(aX);if(false===aA){aB()}})};var A=function(){au=aq.displayAdCmd||[];aq.displayAdCmd=au};var N=function(){var aX=av();A();if(au.length>0){for(var aW=0;aW<au.length;aW++){d(au[aW])}}au={};au.push=function(aY){d(aY)};if(true===aU&&false===aX.disable_initial_load&&false===aA){aB()}aq.displayAdCmd=au};var aj=function(){var aW=av();if(!aW){return}ar.push("Initialize "+(aU?"a":"")+"synchronous ads "+(aa?"on document ready ":"")+"with settings:\n",aW);ao.cmd.push(O)};var w=function(){var a0=av(),a2="script",aZ,aX="https:",aY=document.createElement(a2),aW=aX===document.location.protocol,a1;if(!!a0){aZ=a0.script}else{ar.push("!!!ERROR: Unable to get settings!!!")}if(a===true){ar.push("Ad script already loaded!");return}if(!!aZ){aZ=(aW?aX:"http:")+a0.script;if(aU===true){ar.push("Lazy loading ad script");aY.id=i;aY.async=true;aY.type="text/javascript";aY.src=aZ;a1=document.getElementsByTagName(a2)[0];a1.parentNode.insertBefore(aY,a1);a=true}}};var ag=function(){if(false===a){w()}aj();if(at.length>0){for(var aW=0;aW<at.length;aW++){ao.cmd.push(at[aW])}}};(function(){var aX=ab(i),aW=av();aU=aW.deferred;if(!!aX){a=true}ao=aq.googletag||{};ao.cmd=ao.cmd||[];if(!!ao.cmd&&!!ao.cmd.length&&ao.cmd.length>0){at=ao.cmd;ao.cmd=[]}aq.googletag=ao;if(aU===true){var aY=aq.jQuery;if(!!aY){aY(y).ready(function(){aa=true;ag()})}else{ag()}}else{aj()}})()})(this);
var bk_ignore_meta=true;(function(a){var c=a.document,d=$(c);var b=function(){if(typeof(bk_addPageCtx)!="function"){return}var e=$("meta[name=bluekaiParams]").attr("content");if(typeof(e)=="undefined"||!e){return}e=$.parseJSON(e);if(e&&e.length>0){if(typeof(e.pageParams)!="undefined"){$.each(e.pageParams,function(f,g){bk_addPageCtx(f,g.toString())})}if(typeof(bk_doJSTag)=="function"){bk_doJSTag(e.siteId,4)}}else{return false}};d.ready(b)})(this,jQuery);
(function(b){if(!b.jQuery){return}var d=b.jQuery,h=b.siteAdsLogger||[];var c;var j=function(){if(c===undefined){var l=d("#nrelate-settings");if(l.length<1){c=null}else{c=d.parseJSON(l.attr("content"))}}return c};var g=function(){var p=j(),m=b.nRelate,o=b.DW,n="ria",t="log",r={mapp:"nrelate",comptype:"widget",comp:p.widget_params.widget_id.toString(),riaevent:"",s6:document.location},l,q;if(!!m&&!!m.setup){m.setup({plugins:{related:p.widget_params}})}else{return}if(!!o&&!!o.levt){l=d.extend({},r,{riaevent:"view",s7:p.widget_params.geo});q=d.extend({},r,{riaevent:"click"});o.levt(n,t,l);d("#nrelate_related_placeholder").on("click","a",function(){o.levt(n,t,q)})}};var i;var a=false;var k={dataType:"script",complete:function(l,m){if(m==="success"){a=true}},success:g};var f=function(){var l=j();if(l===null||!l.script||a){return}k.url=l.script;i=d.ajax(k)};var e=function(){var l=j(),m;if(l===null){return}for(m in l.params){if(l.params.hasOwnProperty(m)){b["nr_"+m]=l.params[m]}}if(l.widget_params!==undefined){f()}};d(window).on("load",function(){h.push("Window loaded");e()})})(this);
(function(c){var d=c.jQuery;if(!d){return}var i=c.siteAdsLogger||[];var a;var k=function(){var m=a;if(undefined===m){var l=d("#apex-settings");if(!l||l.length<1){m=null}else{m=l.attr("content")}try{m=d.parseJSON(m)}catch(n){m=null}a=m}return m};var b=function(){var m=k(),l=m.params,n=c.cbsiRunApexTargets;if(n){i.push("[APEX] Run Apex targets: ",l);n(l,1000);i.push("[APEX] Initialized")}};var j=false;var g=function(l){i.push("[APEX] script loaded: ",l);b()};var e=function(l){if(j){return}i.push("[APEX] script failed to load: ",l);j=true};var f=function(n){var l,m;m=d('script[src="'+n+'"]');if(!!m&&0<m.length){g(n);return}l=d.ajax({url:n,dataType:"script",success:function(){g(n)}}).fail(function(){e(n)});i.push("[APEX] Load script: ",n)};var h=function(){var m=k(),l;i.push("[APEX] Begin");if(!m){i.push("[APEX] [ERROR] Unable to find settings, quitting.");return}i.push("[APEX] Settings: ",m);l=m.apex_script;f(l)};d(window).on("load",function(){h()})})(this);
(function(c){if(!c.jQuery){return}var e=c.jQuery,h=c.siteAdsLogger||[];var d;var j=function(){if(d===undefined){var l=e("#outbrain-settings");if(l.length<1){d=null}else{d=e.parseJSON(l.attr("content"))}}return d};var b=function(){var p=j(),m=c.outbrain,o=c.DW,n="ria",t="log",r={mapp:"outbrain",comptype:"widget",comp:p.widget_params.widget_id.toString(),riaevent:"",s6:document.location},l,q;if(!!m&&!!m.setup){m.setup({plugins:{related:p.widget_params}})}else{return}if(!!o&&!!o.levt){l=e.extend({},r,{riaevent:"view",s7:p.widget_params.geo});q=e.extend({},r,{riaevent:"click"});o.levt(n,t,l);e("#outbrain_related_placeholder").on("click","a",function(){o.levt(n,t,q)})}};var i;var a=false;var k={dataType:"script",complete:function(l,m){if(m==="success"){a=true}},success:b};var f=function(){var l=j();if(l===null||!l.script||a){return}k.url=l.script;i=e.ajax(k)};var g=function(){var l=j(),m;if(l===null){return}for(m in l.params){if(l.params.hasOwnProperty(m)){c["ob_"+m]=l.params[m]}}if(l.widget_params!==undefined){f()}};e(window).on("load",function(){h.push("Window loaded");g()})})(this);