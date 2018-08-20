# freemarker-extras-shiro
<h2>
    <a id="user-content-freemarker-extras-shiro" class="anchor" aria-hidden="true" href="#freemarker-extras-shiro">
    </a>
    freemarker-extras-shiro
</h2>
<p>
    A 
    <a href="https://freemarker.apache.org/">freemarker</a> 
    dialect for 
    <a href="https://shiro.apache.org/">Apache Shiro</a>
    <a href="https://shiro.apache.org/tags">tags</a>
</p>
<h2>
    <a id="user-content-download" class="anchor" aria-hidden="true" href="#download"></a>
    Download
</h2>
<h5>
    <a id="user-content-maven" class="anchor" aria-hidden="true" href="#maven"></a>
    Maven
</h5>
<pre>
<code>
    &lt;dependency&gt;
        &lt;groupId&gt;com.zerone&lt;/groupId&gt;
        &lt;artifactId&gt;freemarker-extras-shiro&lt;/artifactId&gt;
        &lt;version&gt;${freemarker-shiro.version}&lt;/version&gt;
    &lt;/dependency&gt;
</code>
</pre>
<h5>
    <a id="user-content-jar" class="anchor" aria-hidden="true" href="#jar"></a>
    Jar
</h5>
<p>
    <a href="#" rel="nofollow">Download</a>
     from Maven Central.
</p>
<h5>
    <a id="user-content-repository" class="anchor" aria-hidden="true" href="#repository"></a>
    Repository
</h5>
<pre>
    <code>git clone https://github.com/vansee/freemarker-extras-shiro.git</code>
</pre>
<h2>
    <a id="user-content-example" class="anchor" aria-hidden="true" href="#example"></a>
    Example
</h2>
<div class="highlight highlight-text-html-basic">
    <pre>
    <core>
    &lt;!DOCTYPE html&gt;
    &lt; lang="en"&gt;
    &lt;head&gt;
        &lt;meta charset="UTF-8"&gt;
        &lt;title&gt;Shiro Tags Usage With Freemarker&lt;/title&gt;
    &lt;/head&gt;
    &lt;body&gt;
        &lt;h3&gt;shiro.guest&lt;/h3&gt;
        &lt;@shiro.guest&gt;
            &lt;p&gt;Hi there! Please &lt;a href="login.html"&gt;Login&lt;/a&gt; or &lt;a href="signup.html"&gt;Signup&lt;/a&gt; today!&lt;/p&gt;
        &lt;&#47;@shiro.guest&gt;
        &lt;&#47;br&gt;
        &lt;h3&gt;shiro.user&lt;/h3&gt;
        &lt;@shiro.user&gt;
            &lt;div&gt;Welcome back John! Not John? Click &lt;a href="login.html"&gt;here&lt;/a&gt; to login.&lt;/div&gt;
        &lt;&#47;@shiro.user&gt;
    &lt;/body&gt;
    &lt;/html&gt;
    </core>
    </pre>
</div>
<h3>
    <a id="user-content-tags" class="anchor" aria-hidden="true" href="#tags"></a>
    Tags
</h3>
<p>The following examples show how to integrate the tags in your Freemarker templates.
These are all implementations of the examples given in the <a href="http://shiro.apache.org/web.html#Web-JSP%252FGSPTagLibrary" rel="nofollow">JSP / GSP Tag Library Section</a> of the Apache Shiro documentation.
</p>
<p>Tags can be written in element notation:</p>
<h5>
    <a id="user-content-element" class="anchor" aria-hidden="true" href="#element"></a>
    Element
</h5>
<div class="highlight highlight-text-html-basic">
<pre>
&lt;<span class="pl-ent"><span class="pl-ii">@shiro.anyTag</span></span>&gt;
    &lt;<span class="pl-ent">p</span>&gt;Hello World!&lt;/<span class="pl-ent">p</span>&gt;
&lt;/<span class="pl-ent"><span class="pl-ii">@shiro.anyTag</span></span>&gt;
</pre>
</div>
<h4>shiro.guest</h4>
<div class="highlight highlight-text-html-basic">
<pre>
&lt;<span class="pl-ent"><span class="pl-ii">@shiro.guest</span></span>&gt;
    &lt;<span class="pl-ent">p</span>&gt;Hi there! Please <a href="login.html">Login</a> or <a href="signup.html">Signup</a> today!&lt;/<span class="pl-ent">/p</span>&gt;
&lt;/<span class="pl-ent"><span class="pl-ii">@shiro.guest</span></span>&gt;
</pre>
</div>
<h4>shiro.user</h4>
<div class="highlight highlight-text-html-basic">
<pre>
&lt;<span class="pl-ent"><span class="pl-ii">@shiro.user</span></span>&gt;
    &lt;<span class="pl-ent">div</span>&gt;Welcome back John! Not John? Click <a href="login.html">here</a> to login.&lt;<span class="pl-ent">/div</span>&gt;
&lt;<span class="pl-ent"><span class="pl-ii">/@shiro.user</span></span>&gt;
</pre>
</div>
<h4>shiro.authenticated</h4>
<div class="highlight highlight-text-html-basic">
<pre>
&lt;<span class="pl-ent"><span class="pl-ii">@shiro.notAuthenticated</span></span>&gt;
    Please <a href="login.html">login</a> in order to update your credit card information.
&lt;<span class="pl-ent"><span class="pl-ii">/@shiro.notAuthenticated</span></span>&gt;
</pre>
</div>
<h4>shiro.principal</h4>
<div class="highlight highlight-text-html-basic">
<pre>
&lt;<span class="pl-ent">p</span>&gt;Hello,
    &lt;<span class="pl-ent"><span class="pl-ii">@shiro.principal/</span></span>&gt;
    , how are you today?
&lt;<span class="pl-ent">/p</span>&gt;
&lt;<span class="pl-ent">p>Hello,
    &lt;<span class="pl-ent"><span class="pl-ii">@shiro.principal type="your class type full class path" property="attribute name of class"/</span></span>&gt;
    , how are you today?
&lt;<span class="pl-ent">/p</span>&gt;
</pre>
</div>
<h4>shiro.lacksRole</h4>
<div class="highlight highlight-text-html-basic">
<pre>
&lt;<span class="pl-ent"><span class="pl-ii">@shiro.lacksRole name="administrator"</span></span>&gt;
    Sorry, you are not allowed to administer the system.
&lt;<span class="pl-ent"><span class="pl-ii">/@shiro.lacksRole</span></span>&gt;
</pre>
</div>
<h4>shiro.hasAllRoles</h4>
<div class="highlight highlight-text-html-basic">
<pre>
&lt;<span class="pl-ent"><span class="pl-ii">@shiro.hasAllRoles name="developer, project manager"</span></span>&gt;
    &lt;<span class="pl-ent">p</span>&gt;You are a developer and a project manager.&lt;<span class="pl-ent">/p</span>&gt;
&lt;<span class="pl-ent"><span class="pl-ii">/@shiro.hasAllRoles</span></span>&gt;
</pre>
</div>
<h4>shiro.hasAnyRoles</h4>
<div class="highlight highlight-text-html-basic">
<pre>
&lt;<span class="pl-ent"><span class="pl-ii">@shiro.hasAnyRoles name="developer, project manager, administrator"</span></span>&gt;
    &lt;<span class="pl-ent">p</span>&gt;You are a developer, project manager, or administrator.&lt;<span class="pl-ent">/p</span>&gt;
&lt;<span class="pl-ent"><span class="pl-ii">/@shiro.hasAnyRoles></span></span>&gt;
</pre>
</div>
<h4>shiro.hasPermission</h4>
<div class="highlight highlight-text-html-basic">
<pre>
&lt;<span class="pl-ent"><span class="pl-ii">@shiro.hasPermission name="user:create"</span></span>&gt;
    &lt;<span class="pl-ent">a href="createUser.html"</span>&gt;Create a new User&lt;<span class="pl-ent">/a</span>&gt;
&lt;<span class="pl-ent"><span class="pl-ii">/@shiro.hasPermission</span></span>&gt;
</pre>
</div>
<h4>shiro.lacksPermission</h4>
<div class="highlight highlight-text-html-basic">
<pre>
&lt;<span class="pl-ent"><span class="pl-ii">@shiro.lacksPermission name="user:delete"</span></span>&gt;
    Sorry, you are not allowed to delete user accounts.
&lt;<span class="pl-ent"><span class="pl-ii">/@shiro.lacksPermission</span></span>&gt;
</pre>
</div>
<h4>shiro.hasAllPermissions</h4>
<div class="highlight highlight-text-html-basic">
<pre>
&lt;<span class="pl-ent"><span class="pl-ii">@shiro.hasAllPermissions name="user:create, user:delete"</span></span>&gt;
    &lt;<span class="pl-ent">p</span>&gt;You can create and delete users.&lt;<span class="pl-ent">/p</span>&gt;
&lt;<span class="pl-ent"><span class="pl-ii">/@shiro.hasAllPermissions</span></span>&gt;
</pre>
</div>
<h4>shiro.hasAnyPermissions</h4>
<div class="highlight highlight-text-html-basic">
<pre>
&lt;<span class="pl-ent"><span class="pl-ii">@shiro.hasAnyPermissions name="user:create, user:delete"</span></span>&gt;
    &lt;<span class="pl-ent">p</span>&gt;You can create or delete users.&lt;<span class="pl-ent">/p</span>&gt;
&lt;<span class="pl-ent"><span class="pl-ii">/@shiro.hasAnyPermissions</span></span>&gt;
</pre>
</div>
<h2>
    <a id="user-content-license" class="anchor" aria-hidden="true" href="#license"></a>
    License
</h2>
<p>The project is licensed under the Apache License. See <a href="/vansee/freemarker-extras-shiro/blob/master/LICENSE">LICENSE</a> for details.</p>