import{e as b,o as c,f as h,g as t,t as y,u,F as x,h as T,n as M,p as B,i as D,j as $,k as O,w as g,v as k,l as R,m as W,q as Q,s as r,x as j,T as A,y as q,z as Z,A as P,B as ee,c as G,C as te}from"./vendor.20d16b53.js";import{_ as C}from"./index.3bc73927.js";var se="./assets/calendar.27a5037d.svg",ae="./assets/sun.7b771274.svg",oe="./assets/task.3e7d3419.svg";const le={id:"he-plugin-standard"},ne=b({setup(s){window.WIDGET={CONFIG:{layout:"2",width:"220",height:270,background:"5",dataColor:"000000",borderRadius:"15",key:"de9b548ecee043cdb9075a4b750ebf44"}};{const e=document.createElement("script");e.type="text/javascript",e.src="https://widget.qweather.net/standard/static/js/he-standard-common.js?v=2.0",document.getElementsByTagName("head")[0].appendChild(e)}return(e,a)=>(c(),h("div",le))}});const ie=s=>(B("data-v-60af542f"),s=s(),D(),s),ue={class:"calendar"},ce={id:"week-appear"},de={id:"date-appear"},re={id:"day-appear"},_e=ie(()=>t("li",null,null,-1)),he={class:"week-title"},pe={class:"day-box"},ve={class:"day",key:"i"},me=b({setup(s){var e=new Date().getFullYear(),a=new Date().getMonth()+1,i=new Date().getDate(),d=new Date().getDay(),m=new Array("\u65E5","\u4E00","\u4E8C","\u4E09","\u56DB","\u4E94","\u516D");const f=()=>m[d];var o=new Date(e,a-1,1),p=o.getDay(),v=o-p*60*60*1e3*24+8*60*60*1e3;const w=()=>{var l=[];for(let n=0;n<42;n++)l.push(new Date(v+n*60*60*1e3*24));return l},I=f(),V=l=>{let n=l.getFullYear(),_=l.getMonth()+1;return n===e&&_===a},z=l=>{let n=l.getDate(),_=l.getMonth()+1;return n===i&&_===a};return(l,n)=>(c(),h("div",ue,[t("ul",null,[t("li",ce,"\u5468"+y(u(I)),1),t("li",de,y(u(i)),1),t("li",re,y(u(e))+"\u5E74"+y(u(a))+"\u6708",1),_e,t("ul",he,[(c(!0),h(x,null,T(u(m),_=>(c(),h("li",null,y(_),1))),256))]),t("div",pe,[(c(),h(x,null,T(6,_=>t("ul",ve,[(c(),h(x,null,T(7,F=>t("li",{key:"j",class:M({now:!V(w()[(_-1)*7+(F-1)]),today:z(w()[(_-1)*7+(F-1)])})},y(w()[(_-1)*7+(F-1)].getDate()),3)),64))])),64))])])]))}});var fe=C(me,[["__scopeId","data-v-60af542f"]]),ge="./assets/icon.aca3c23c.svg",we="./assets/check.f2d862d7.svg",$e="./assets/complete.3e52dbc7.svg",ke="./assets/delete.001b7f61.svg";const K=s=>(B("data-v-4d79437a"),s=s(),D(),s),be=K(()=>t("div",{class:"list-bar"},[t("div",{class:"icon"},[t("img",{src:ge})]),t("span",{id:"title",class:"animate__animated animate__heartBeat"},"To-do List")],-1)),ye={class:"list-text"},Ce=["onClick"],Ee=["onClick"],xe=["onClick"],Se={class:"list-foot"},Be=["onKeyup"],De=K(()=>t("span",null,"Submit",-1)),Ie=[De],Fe=b({setup(s){const e=$(""),a=$([]);O(()=>{const o=d();for(let p=0;p<o.length;p++)a.value.push({item:o[p].item,checked:o[p].checked})});const i=()=>{e.value.trim()===""?alert("\u8BF7\u8F93\u5165\u6709\u6548\u7684\u6587\u5B57\uFF01"):(a.value.push({item:e.value,checked:!1}),localStorage.setItem("todo",JSON.stringify(a.value)),e.value="")},d=()=>{const o=localStorage.getItem("todo");return JSON.parse(o)||[]},m=o=>{a.value[o].checked=!a.value[o].checked;const p=d();for(let v=0;v<p.length;v++)p[v].checked=!p[v].checked,localStorage.setItem("todo",JSON.stringify(a.value))},f=o=>{a.value.splice(o,1);const p=d();for(let v=0;v<p.length;v++)p[v].checked=!p[v].checked,localStorage.setItem("todo",JSON.stringify(a.value))};return(o,p)=>(c(),h(x,null,[be,t("ul",ye,[(c(!0),h(x,null,T(a.value,(v,w)=>(c(),h("li",{class:M(["animate__animated animate__fadeInUp",{itemShow:a.value[w].checked}]),key:w},[t("span",null,[g(t("img",{src:we,id:"ok",onClick:I=>m(w)},null,8,Ce),[[k,!a.value[w].checked]]),g(t("img",{src:$e,id:"complete",onClick:I=>m(w)},null,8,Ee),[[k,a.value[w].checked]])]),R(" "+y(v.item)+" ",1),t("span",null,[t("img",{src:ke,id:"delete",onClick:I=>f(w)},null,8,xe)])],2))),128))]),t("div",Se,[g(t("input",{id:"input",type:"text",onKeyup:Q(i,["enter"]),"onUpdate:modelValue":p[0]||(p[0]=v=>e.value=v),maxlength:"14",placeholder:"\u4F60\u6709\u4EC0\u4E48\u4E8B\u60C5\u8981\u505A\u5462\uFF1F"},null,40,Be),[[W,e.value]]),t("button",{class:"button",onClick:i},Ie)])],64))}});var Te=C(Fe,[["__scopeId","data-v-4d79437a"]]);const X=s=>(B("data-v-4d618cf5"),s=s(),D(),s),Me={id:"tools"},Ne={id:"tools-bar"},je=X(()=>t("div",{class:"line"},null,-1)),Ae=X(()=>t("div",{class:"line"},null,-1)),He={class:"list"},Ve={class:"sun"},ze={class:"calendar"},Le=b({setup(s){const e=$(!1),a=$(!1),i=$(!1),d=$(!1),m=$(!1),f=$(!1),o=()=>{i.value=!i.value,d.value=!d.value,(a.value||e.value)&&(e.value=!1,a.value=!1),(f.value||m.value)&&(f.value=!1,m.value=!1)},p=()=>{a.value=!a.value,m.value=!m.value,(i.value||e.value)&&(i.value=!1,e.value=!1),(f.value||d.value)&&(f.value=!1,d.value=!1)},v=()=>{e.value=!e.value,f.value=!f.value,(i.value||a.value)&&(i.value=!1,a.value=!1),(m.value||d.value)&&(m.value=!1,d.value=!1)};return(w,I)=>(c(),h("div",Me,[t("nav",Ne,[t("div",{id:"calendar",onClick:o},[t("img",{src:se,class:M({cal:d.value})},null,2)]),je,t("div",{id:"sun",onClick:p},[t("img",{src:ae,class:M({weather:m.value})},null,2)]),Ae,t("div",{id:"task",onClick:v},[t("img",{src:oe,class:M({td:f.value})},null,2)])]),r(A,{name:"slide"},{default:j(()=>[g(t("ul",He,[r(Te)],512),[[k,e.value]])]),_:1}),r(A,{name:"slide"},{default:j(()=>[g(t("div",Ve,[r(ne)],512),[[k,a.value]])]),_:1}),r(A,{name:"slide"},{default:j(()=>[g(t("div",ze,[r(fe)],512),[[k,i.value]])]),_:1})]))}});var Oe=C(Le,[["__scopeId","data-v-4d618cf5"]]);const H=s=>(B("data-v-5ff95826"),s=s(),D(),s),We={class:"nowDate"},Je={class:"noteText"},Ue=["onContextmenu"],qe=["onClick"],Pe=H(()=>t("i",{class:"l"},null,-1)),Ge=H(()=>t("i",{class:"r"},null,-1)),Ke=[Pe,Ge],Xe={class:"animate_animated animate__flipInX mask"},Ye=H(()=>t("br",null,null,-1)),Re={class:"animate_animated animate__flipInX modify"},Qe=H(()=>t("br",null,null,-1)),Ze={id:"rightMenu"},et=b({setup(s){Z(l=>({"838e970e":u(e).topValue}));let e=q({nowData:"",isshow:!1,textdata:"",noteBooks:[],topValue:"116px",isModifyShow:!1,transferStation:"",modify_num:Number,addshow:!0,ulHidden:!1,details:"",listHidden:!1,itemTransition:"",indexTransition:Number,rightMenuShow:!1});const a=()=>{setInterval(i,500)},i=()=>{let l=new Date,n=l.getMonth()+1,_=l.getDate(),F=l.getDay(),L=["\u5468\u65E5","\u5468\u4E00","\u5468\u4E8C","\u5468\u4E09","\u5468\u56DB","\u5468\u4E94","\u5468\u516D"],S=l.getHours(),Y=S<=12?"\u4E0A\u5348":"\u4E0B\u5348";S=S<=12?S:S-12,S=S<10?"0"+S:S;let N=l.getMinutes();N=N<10?"0"+N:N,e.nowData=`${Y} ${S}:${N} ${L[F]} ${n}\u6708${_}\u65E5`};O(()=>{a();const l=z();for(let n=0;n<l.length;n++)e.noteBooks.push(l[n]);console.log(e.noteBooks[0]),e.noteBooks.length>=1&&(e.ulHidden=!0,e.topValue="196px")});const d=()=>{e.isshow=!0,e.textdata=""},m=()=>{e.isshow=!1,e.textdata&&(e.noteBooks.unshift(e.textdata),e.topValue="196px",e.ulHidden=!0),localStorage.setItem("note",JSON.stringify(e.noteBooks))},f=(l,n)=>{e.isModifyShow=!0,e.transferStation=l,e.modify_num=n},o=l=>{e.noteBooks[l]=e.transferStation,e.isModifyShow=!1,localStorage.setItem("note",JSON.stringify(e.noteBooks))},p=(l,n)=>{e.noteBooks.splice(n,1),e.noteBooks.unshift(l),localStorage.setItem("note",JSON.stringify(e.noteBooks))},v=l=>{e.noteBooks.length!=1?e.noteBooks.splice(l,1):(e.noteBooks.splice(l,1),e.addshow=!0,e.topValue="116px",w(),e.ulHidden=!1),e.rightMenuShow=!1,localStorage.setItem("note",JSON.stringify(e.noteBooks))},w=()=>{e.addshow=!0,e.listHidden=!1,e.rightMenuShow=!1,e.ulHidden=!e.ulHidden},I=()=>{e.addshow=!1,e.listHidden=!0,e.ulHidden=!e.ulHidden},V=(l,n,_)=>{e.itemTransition=l,e.indexTransition=n,e.rightMenuShow=!0,document.getElementById("rightMenu").style.top=_.clientY+"px",document.getElementById("rightMenu").style.left=_.clientX+"px"};document.addEventListener("click",()=>{e.rightMenuShow=!1},!1);const z=()=>{let l=localStorage.getItem("note");return JSON.parse(l)||[]};return(l,n)=>(c(),h(x,null,[t("div",We,y(u(e).nowData),1),g(t("div",{class:"animate_animated animate__fadeInTopLeft staticPresentation",onClick:I},y(u(e).noteBooks[0]),513),[[k,u(e).ulHidden]]),r(A,null,{default:j(()=>[g(t("ul",Je,[(c(!0),h(x,null,T(u(e).noteBooks,(_,F)=>(c(),h("li",{class:"animate_animated animate__bounceInDown",onContextmenu:P(L=>V(_,F,L),["right","prevent"])},y(_),41,Ue))),256)),t("li",null,[g(t("button",{class:"cancelBubble-btn",onClick:P(w,["stop"])},"\u6536\u8D77",8,qe),[[k,!u(e).addshow]])])],512),[[k,u(e).listHidden]])]),_:1}),g(t("div",{id:"add",class:"animate_animated animate__bounceIn addNote",onClick:d},Ke,512),[[k,u(e).addshow]]),g(t("div",Xe,[g(t("textarea",{class:"textarea",rows:"4","onUpdate:modelValue":n[0]||(n[0]=_=>u(e).textdata=_),placeholder:"Writing your thoughts."},null,512),[[W,u(e).textdata,void 0,{lazy:!0}]]),Ye,t("button",{onClick:m,class:"savebutton"},"\u4FDD\u5B58\u5E76\u9000\u51FA")],512),[[k,u(e).isshow]]),g(t("div",Re,[g(t("textarea",{class:"modify_textarea",rows:"4","onUpdate:modelValue":n[1]||(n[1]=_=>u(e).transferStation=_)},null,512),[[W,u(e).transferStation]]),Qe,t("button",{class:"modify_button",onClick:n[2]||(n[2]=_=>o(u(e).modify_num))},"\u4FDD\u5B58\u4FEE\u6539")],512),[[k,u(e).isModifyShow]]),g(t("ul",Ze,[t("li",{onClick:n[3]||(n[3]=_=>p(u(e).itemTransition,u(e).indexTransition))},"\u7F6E\u9876"),t("li",{onClick:n[4]||(n[4]=_=>f(u(e).itemTransition,u(e).indexTransition))},"\u4FEE\u6539"),t("li",{onClick:n[5]||(n[5]=_=>v(u(e).indexTransition))},"\u5220\u9664")],512),[[k,u(e).rightMenuShow]])],64))}});var tt=C(et,[["__scopeId","data-v-5ff95826"]]);const st={class:"website-item"},at=["href"],ot=b({props:{name:{type:String,default:""},webpath:{type:String,default:"1"},nameClass:{type:String}},setup(s){return(e,a)=>(c(),h("div",st,[t("a",{href:s.webpath},[t("div",{class:"website-icon",style:ee(`background-image:url(${s.webpath}/favicon.ico);`)},null,4),t("div",{class:M(["website-name",s.nameClass])},y(s.name),3)],8,at)]))}});var E=C(ot,[["__scopeId","data-v-2cfd7bcb"]]);const lt={class:"wrapper"},nt={class:"frame12"},it={class:"frame13"},ut={class:"frame10"},ct=b({setup(s){return(e,a)=>(c(),h("div",lt,[t("div",nt,[r(E,{name:"\u6398\u91D1",nameClass:"juejin",webpath:"https://juejin.cn"}),r(E,{name:"\u7B80\u4E66",nameClass:"jianshu",webpath:"https://www.jianshu.com/"}),r(E,{name:"\u725B\u5BA2\u7F51",nameClass:"niuke",webpath:"https://www.nowcoder.com/"}),r(E,{name:"Bilibili",nameClass:"bilibili",webpath:"https://www.bilibili.com"})]),t("div",it,[r(E,{name:"CSDN",nameClass:"csdn",webpath:"https://www.csdn.net/"}),r(E,{name:"Github",nameClass:"github",webpath:"https://github.com/"}),r(E,{name:"\u529B\u6263",nameClass:"leetcode",webpath:"https://leetcode-cn.com/"}),r(E,{name:"\u77E5\u4E4E",nameClass:"zhihu",webpath:"https://www.zhihu.com//"})]),t("div",ut,[r(E),r(E),r(E),r(E)])]))}});var dt=C(ct,[["__scopeId","data-v-4810dd9a"]]);const rt=s=>(B("data-v-2f544a1c"),s=s(),D(),s),_t={class:"block"},ht={class:"up"},pt=["src"],vt=rt(()=>t("br",null,null,-1)),mt=b({props:{src:{type:String},text:{type:String}},setup(s){return(e,a)=>(c(),h("div",_t,[t("div",ht,[t("img",{src:s.src,alt:"\u4E3B\u9898\u7F29\u7565\u56FE",class:"img"},null,8,pt)]),vt,t("h1",null,y(s.text),1)]))}});var ft=C(mt,[["__scopeId","data-v-2f544a1c"]]);const gt={},J=s=>(B("data-v-d26cf6f8"),s=s(),D(),s),wt={class:"sword"},$t=J(()=>t("span",null,null,-1)),kt=J(()=>t("span",null,null,-1)),bt=J(()=>t("span",null,null,-1)),yt=[$t,kt,bt];function Ct(s,e){return c(),h("div",wt,yt)}var Et=C(gt,[["render",Ct],["__scopeId","data-v-d26cf6f8"]]);const xt=s=>(B("data-v-4860adc8"),s=s(),D(),s),St=xt(()=>t("div",{class:"plus"},[t("span",{class:"line1"}),t("span",{class:"line2"})],-1)),Bt=[St],Dt=b({setup(s){const e={types:[{description:"Images",accept:{"image/*":[".png",".gif",".jpeg",".jpg"]}}],excludeAcceptAllOption:!0,multiple:!1},a=()=>{window.showOpenFilePicker(e)};return(i,d)=>(c(),h("div",{class:"upload",onClick:a},Bt))}});var It=C(Dt,[["__scopeId","data-v-4860adc8"]]),Ft="./assets/8d92efcdb0007a3af8e277731bcb561b.d183a450.jpg",Tt="./assets/2.ee5afbfa.jpg",Mt="./assets/3.b60c14d7.jpg",Nt="./assets/4.4b8dd0cf.jpg",jt="./assets/5.89b8360d.jpg",At="./assets/6.47313c6e.jpg",Ht="./assets/7.14d9a3d0.jpg",Vt="./assets/8.f15b39db.jpg",zt="./assets/9.93486f90.jpg",Lt="./assets/10.4659b37b.jpg";const U=s=>(B("data-v-693bfae4"),s=s(),D(),s),Ot={class:"Dialog"},Wt=U(()=>t("svg",{x:"1644496080139",class:"icon",viewBox:"0 0 1024 1024",xmlns:"http://www.w3.org/2000/svg","p-id":"1350",width:"35",height:"35"},[t("path",{d:"M512 960c-247.039484 0-448-200.960516-448-448S264.960516 64 512 64 960 264.960516 960 512 759.039484 960 512 960zM512 128.287273c-211.584464 0-383.712727 172.128262-383.712727 383.712727 0 211.551781 172.128262 383.712727 383.712727 383.712727 211.551781 0 383.712727-172.159226 383.712727-383.712727C895.712727 300.415536 723.551781 128.287273 512 128.287273z","p-id":"1351"}),t("path",{d:"M557.05545 513.376159l138.367639-136.864185c12.576374-12.416396 12.672705-32.671738 0.25631-45.248112s-32.704421-12.672705-45.248112-0.25631l-138.560301 137.024163-136.447897-136.864185c-12.512727-12.512727-32.735385-12.576374-45.248112-0.063647-12.512727 12.480043-12.54369 32.735385-0.063647 45.248112l136.255235 136.671523-137.376804 135.904314c-12.576374 12.447359-12.672705 32.671738-0.25631 45.248112 6.271845 6.335493 14.496116 9.504099 22.751351 9.504099 8.12794 0 16.25588-3.103239 22.496761-9.247789l137.567746-136.064292 138.687596 139.136568c6.240882 6.271845 14.432469 9.407768 22.65674 9.407768 8.191587 0 16.352211-3.135923 22.591372-9.34412 12.512727-12.480043 12.54369-32.704421 0.063647-45.248112L557.05545 513.376159z","p-id":"1352"})],-1)),Jt=[Wt],Ut={class:"BlockWarp",ref:"BlockEle"},qt={class:"LoadText"},Pt=U(()=>t("p",null,"\u4E0B\u6ED1\u52A0\u8F7D\u66F4\u591A\u6570\u636E",-1)),Gt=[Pt],Kt={class:"LoadText"},Xt=U(()=>t("p",null,"\u6570\u636E\u5DF2\u5168\u90E8\u52A0\u8F7D\u5B8C\u6210",-1)),Yt=[Xt],Rt=b({props:{flag:{type:Boolean}},emits:["update:flag"],setup(s,{emit:e}){const a=()=>{e("update:flag",!1)};let i=$(!1),d=$(!1),m=q([{id:1,title:"\u57CE\u5E02\u665A\u971E",path:Ft},{id:2,title:"\u6D77\u5929\u4E00\u8272",path:Tt},{id:3,title:"\u60AC\u5D16\u8FB9\u7684\u6D3E\u5927\u661F",path:Mt},{id:4,title:"\u7EFF\u8272\u62A4\u773C",path:Nt},{id:5,title:"\u5927\u96C4\u548C\u5C0F\u4F19\u4F34",path:jt},{id:6,title:"\u864E\u5E74\u5927\u5409",path:At},{id:7,title:"\u5C71\u6D77\u4E0E\u4F60",path:Ht}]);O(()=>{document.getElementById("page").className=localStorage.getItem("theme")||"theme";const o=document.getElementsByClassName("BlockWarp")[0];o.addEventListener("scroll",()=>{o.scrollTop+o.clientHeight+1>=o.scrollHeight&&m.length<10&&(d.value=!0,i.value=!0,setTimeout(()=>{m.push({id:8,title:"\u9022\u8003\u5FC5\u8FC7",path:Vt},{id:9,title:"\u670B\u514B\u65F6\u4EE3",path:zt},{id:10,title:"\u864E\u5E74\u5927\u5409",path:Lt}),d.value=!1,i.value=!1},1e3))})});const f=o=>{localStorage.setItem("theme",`theme${o}`),i.value=!0,setTimeout(()=>{i.value=!1,document.getElementById("page").className=`theme${o}`},1300)};return(o,p)=>(c(),h(x,null,[g(t("div",Ot,[t("div",{class:"CloseIcon",onClick:a},Jt),t("div",Ut,[(c(!0),h(x,null,T(u(m),v=>(c(),G(ft,{onClick:w=>f(v.id),src:v.path,text:v.title},null,8,["onClick","src","text"]))),256)),r(It),g(t("div",qt,Gt,512),[[k,u(d)]]),g(t("div",Kt,Yt,512),[[k,!u(d)]])],512)],512),[[k,s.flag]]),u(i)?(c(),G(Et,{key:0})):te("",!0)],64))}});var Qt=C(Rt,[["__scopeId","data-v-693bfae4"]]);const Zt=s=>(B("data-v-204bc850"),s=s(),D(),s),es=Zt(()=>t("svg",{x:"1645003849705",class:"icon",viewBox:"0 0 1024 1024",xmlns:"http://www.w3.org/2000/svg","p-id":"2394",width:"40",height:"40"},[t("path",{d:"M938.666667 553.92V768c0 64.8-52.533333 117.333333-117.333334 117.333333H202.666667c-64.8 0-117.333333-52.533333-117.333334-117.333333V256c0-64.8 52.533333-117.333333 117.333334-117.333333h618.666666c64.8 0 117.333333 52.533333 117.333334 117.333333v297.92z m-64-74.624V256a53.333333 53.333333 0 0 0-53.333334-53.333333H202.666667a53.333333 53.333333 0 0 0-53.333334 53.333333v344.48A290.090667 290.090667 0 0 1 192 597.333333a286.88 286.88 0 0 1 183.296 65.845334C427.029333 528.384 556.906667 437.333333 704 437.333333c65.706667 0 126.997333 16.778667 170.666667 41.962667z m0 82.24c-5.333333-8.32-21.130667-21.653333-43.648-32.917333C796.768 511.488 753.045333 501.333333 704 501.333333c-121.770667 0-229.130667 76.266667-270.432 188.693334-2.730667 7.445333-7.402667 20.32-13.994667 38.581333-7.68 21.301333-34.453333 28.106667-51.370666 13.056-16.437333-14.634667-28.554667-25.066667-36.138667-31.146667A222.890667 222.890667 0 0 0 192 661.333333c-14.464 0-28.725333 1.365333-42.666667 4.053334V768a53.333333 53.333333 0 0 0 53.333334 53.333333h618.666666a53.333333 53.333333 0 0 0 53.333334-53.333333V561.525333zM320 480a96 96 0 1 1 0-192 96 96 0 0 1 0 192z m0-64a32 32 0 1 0 0-64 32 32 0 0 0 0 64z","p-id":"2395",fill:"#e6e6e6"})],-1)),ts=[es],ss=b({setup(s){const e=$(!1);return(a,i)=>(c(),h(x,null,[t("div",{class:"wallpaper",onClick:i[0]||(i[0]=d=>e.value=!e.value)},ts),r(Qt,{flag:e.value,"onUpdate:flag":i[1]||(i[1]=d=>e.value=d)},null,8,["flag"])],64))}});var as=C(ss,[["__scopeId","data-v-204bc850"]]),os="./assets/search-normal.9abb2eb9.svg";const ls=b({setup(){const s=$("https://www.baidu.com/s"),e=$(""),a=$("\u767E\u5EA6\u4E00\u4E0B"),i=$(0);return{searchPrefix:s,searchParam:e,place:a,current_index:i,searchEngines:[{id:1,name:"\u767E\u5EA6",description:"\u767E\u5EA6\u4E00\u4E0B",url:"https://www.baidu.com/s",value:"wd"},{id:2,name:"\u8C37\u6B4C",description:"\u8C37\u6B4C\u641C\u7D22",url:"https://www.google.com.hk/search",value:"query"},{id:3,name:"\u5FC5\u5E94",description:"\u5FAE\u8F6FBing",url:"https://cn.bing.com/search",value:"q"},{id:4,name:"Github",description:"\u6E90\u4EE3\u7801\u641C\u7D22",url:"https://github.com/search",value:"q"},{id:5,name:"Bilibili",description:"\u54D4\u54E9\u54D4\u54E9\u641C\u7D22",url:"https://search.bilibili.com/all",value:"keyword"}],handleSearchTabClick:(f,o)=>{i.value=f,s.value=o.url,e.value=o.value,a.value=o.description}}}}),ns=s=>(B("data-v-29b0a86c"),s=s(),D(),s),is={class:"search"},us={class:"search-nav"},cs=["onClick"],ds={class:"search-box"},rs=["action"],_s=["name","placeholder"],hs=ns(()=>t("button",{class:"search-btn",type:"submit"},[t("img",{src:os,alt:"search-icon"})],-1));function ps(s,e,a,i,d,m){return c(),h("div",is,[t("ul",us,[(c(!0),h(x,null,T(s.searchEngines,(f,o)=>(c(),h("li",{onClick:p=>s.handleSearchTabClick(o,f),class:M(["active",{selected:s.current_index===o}])},y(f.name),11,cs))),256))]),t("div",ds,[t("form",{class:"search-box-items",action:s.searchPrefix,method:"get",target:"_blank"},[t("input",{type:"text",class:"search-in",name:s.searchParam,placeholder:s.place},null,8,_s),hs],8,rs)])])}var vs=C(ls,[["render",ps],["__scopeId","data-v-29b0a86c"]]);const ms={id:"page"},fs=b({setup(s){return(e,a)=>(c(),h("div",ms,[r(Oe),r(tt),r(vs),r(dt),r(as)]))}});var $s=C(fs,[["__scopeId","data-v-e1763a1a"]]);export{$s as default};
