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
        &lt;&#47;br&gt;
        &lt;h3&gt;shiro.authenticated&lt;/h3&gt;
        &lt;@shiro.notAuthenticated&gt;
            Please &lt;a href="login.html"&gt;login&lt;/a&gt; in order to update your credit card information.
        &lt;&#47;@shiro.notAuthenticated&gt;
        &lt;&#47;br&gt;
        &lt;h3&gt;shiro.principal&lt;/h3&gt;
        &lt;p&gt;Hello,
            &lt;@shiro.principal/&gt;
            , how are you today?
        &lt;/p&gt;
        &lt;p&gt;Hello,
            &lt;@shiro.principal type="your class type full class path" property="attribute name of class"/&gt;
            , how are you today?
        &lt;/p&gt;
        &lt;&#47;br&gt;
        &lt;h3&gt;shiro.lacksRole&lt;/h3&gt;
        &lt;@shiro.lacksRole name="administrator"&gt;
            Sorry, you are not allowed to administer the system.
        &lt;&#47;@shiro.lacksRole&gt;
        &lt;&#47;br&gt;
        &lt;h3&gt;shiro.hasAllRoles&lt;/h3&gt;
        &lt;@shiro.hasAllRoles name="developer, project manager"&gt;
            &lt;p&gt;You are a developer and a project manager.&lt;/p&gt;
        &lt;&#47;@shiro.hasAllRoles&gt;
        &lt;&#47;br&gt;
        &lt;h3&gt;shiro.hasAnyRoles&lt;/h3&gt;
        &lt;@shiro.hasAnyRoles name="developer, project manager, administrator"&gt;
            &lt;p&gt;You are a developer, project manager, or administrator.&lt;/p&gt;
        &lt;&#47;@shiro.hasAnyRoles&gt;
        &lt;&#47;br&gt;
        &lt;h3&gt;shiro.hasPermission&lt;/h3&gt;
        &lt;@shiro.hasPermission name="user:create"&gt;
            &lt;a href="createUser.html"&gt;Create a new User&lt;/a&gt;
        &lt;&#47;@shiro.hasPermission&gt;
        &lt;&#47;br&gt;
        &lt;h3&gt;shiro.lacksPermission&lt;/h3&gt;
        &lt;@shiro.lacksPermission name="user:delete"&gt;
            Sorry, you are not allowed to delete user accounts.
        &lt;&#47;@shiro.lacksPermission&gt;
        &lt;&#47;br&gt;
        &lt;h3&gt;shiro.hasAllPermissions&lt;/h3&gt;
        &lt;@shiro.hasAllPermissions name="user:create, user:delete"&gt;
            &lt;p&gt;You can create and delete users.&lt;/p&gt;
        &lt;&#47;@shiro.hasAllPermissions&gt;
        &lt;&#47;br&gt;
        &lt;h3&gt;shiro.hasAnyPermissions&lt;/h3&gt;
        &lt;@shiro.hasAnyPermissions name="user:create, user:delete"&gt;
            &lt;p&gt;You can create or delete users.&lt;/p&gt;
        &lt;&#47;@shiro.hasAnyPermissions&gt;
        &lt;&#47;br&gt;
    &lt;/body&gt;
    &lt;/html&gt;
    </core>
    </pre>
</div>