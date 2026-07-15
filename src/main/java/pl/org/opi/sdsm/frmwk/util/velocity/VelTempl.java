package pl.org.opi.sdsm.frmwk.util.velocity;

import lombok.extern.slf4j.Slf4j;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.apache.velocity.tools.generic.EscapeTool;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class VelTempl {
    
    public static final String UTF_8 = "UTF-8";
    
    private final String resourcePath;
    private final Map<String, Object> params = new HashMap<>();

    public VelTempl(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public VelTempl(String resourcePath, Map<String, Object> params) {
        this.resourcePath = resourcePath;
        this.params.putAll(params);
    }

    protected void initContextWithParams(VelocityContext context, Map<String, Object> params) {
        if (params != null) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                context.put(entry.getKey(), entry.getValue());
            }
        }
    }
    
    public String build() {
        try {
            String path = this.resourcePath;
            if (path.charAt(0) == '/') {
                path = path.substring(1);
            }
            VelocityEngine engine = new VelocityEngine();
            engine.setProperty(RuntimeConstants.RESOURCE_LOADERS, "classpath");
            engine.setProperty(RuntimeConstants.RESOURCE_LOADER + ".classpath.class", ClasspathResourceLoader.class.getName());
            engine.setProperty(RuntimeConstants.RESOURCE_LOADER + ".classpath.cache", "false");
            engine.setProperty(RuntimeConstants.RESOURCE_LOADER + ".classpath.modification_check_interval", "2");
            engine.init();
            Template template = engine.getTemplate(path, UTF_8);
            VelocityContext context = new VelocityContext();
            context.put("esc", new EscapeTool());
            initContextWithParams(context, params);
            StringWriter writer = new StringWriter();
            template.merge(context, writer);
            return writer.toString();
        } catch (MethodInvocationException | ParseErrorException | ResourceNotFoundException ex) {
            log.error("Błąd ładowania szablonu velocity: ", ex);
            return null;
        }
        
    }
    
}
