package generator;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
 
public class TestCaseGenerator {
	DocumentBuilderFactory docFactory;
	DocumentBuilder docBuilder;
	Document doc;
	Element aConfig;
	// General configuration
	Element framework, system, experiment;
	// Controllers
	Element controllers, footbot_flocking_controller;
	Element actuators, differential_steering, leds;
	Element sensors, footbot_light, colored_blob_omnidirectional_camera;
	Element params, wheel_turning, flocking;
	// Arena configuration
	Element arena, floor, light, distribute;
	Element position, orientation, entity, foot_bot, controller;
	// Physics engines
	Element physics_engines, dynamics2d;
	// Media
	Element media, led;
	// Visualization
	Element visualization, qt_opengl, camera, placement;
	
	TransformerFactory transformerFactory;
	Transformer transformer;
	DOMSource source;
	StreamResult result;
	
	int count;

	public TestCaseGenerator(){
		count = 0;
		argosConfiguration();
	}
	
	private Element createBox(Element box, Element body, Descriptor des){
		
		String id, size, movable, position, orientation;
		id = "Wall"+Integer.toString(count);
		count++;
		size = des.getL()+","+des.getW()+",1";
		movable = "false";
		
		position = des.getX()+","+des.getY()+",0";
		orientation = des.getO()+",0,0";
		box.setAttribute("id", id);
		box.setAttribute("size", size);
		box.setAttribute("movable", movable);
		body.setAttribute("position", position);
		body.setAttribute("orientation", orientation);
		box.appendChild(body);
		return box;
	}
	
	
	private void argosConfiguration(){
		try {
			docFactory = DocumentBuilderFactory.newInstance();
			docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();
			aConfig = doc.createElement("argos-configuration");
			doc.appendChild(aConfig);
			
			// General configuration
			framework = doc.createElement("framework");
			
			system = doc.createElement("system");
			system.setAttribute("threads","0");
			framework.appendChild(system);
			
			experiment = doc.createElement("experiment");
			experiment.setAttribute("length", "0");
			experiment.setAttribute("ticks_per_second","10");
			experiment.setAttribute("random_seed", "124");
			
			framework.appendChild(experiment);	
			aConfig.appendChild(framework);
			
			// Controllers
			controllers = doc.createElement("controllers");
			
			footbot_flocking_controller = doc.createElement("footbot_flocking_controller");
			footbot_flocking_controller.setAttribute("id", "ffc");
			footbot_flocking_controller.setAttribute("library", "build/controllers/footbot_flocking/libfootbot_flocking");
			
			
			actuators = doc.createElement("actuators");
			
			differential_steering = doc.createElement("differential_steering");
			differential_steering.setAttribute("implementation", "default");
			actuators.appendChild(differential_steering);
			
			leds = doc.createElement("leds");
			leds.setAttribute("implementation", "default");
			leds.setAttribute("medium", "leds");
			actuators.appendChild(leds);
			
			footbot_flocking_controller.appendChild(actuators);
			
			sensors = doc.createElement("sensors");
			
			footbot_light = doc.createElement("footbot_light");
			footbot_light.setAttribute("implementation", "rot_z_only");
			footbot_light.setAttribute("show_rays", "true");
			sensors.appendChild(footbot_light);
			
			colored_blob_omnidirectional_camera = doc.createElement("colored_blob_omnidirectional_camera");
			colored_blob_omnidirectional_camera.setAttribute("implementation", "rot_z_only");
			colored_blob_omnidirectional_camera.setAttribute("medium", "leds");
			colored_blob_omnidirectional_camera.setAttribute("show_rays", "true");
			sensors.appendChild(colored_blob_omnidirectional_camera);
			footbot_flocking_controller.appendChild(sensors);
			
			params = doc.createElement("params");
			wheel_turning = doc.createElement("wheel_turning");
			wheel_turning.setAttribute("hard_turn_angle_threshold", "90");
			wheel_turning.setAttribute("soft_turn_angle_threshold", "70");
			wheel_turning.setAttribute("no_turn_angle_threshold", "10");
			wheel_turning.setAttribute("max_speed", "10");
			params.appendChild(wheel_turning);
			
			flocking = doc.createElement("flocking");
			flocking.setAttribute("target_distance", "75");
			flocking.setAttribute("gain", "1000");
			flocking.setAttribute("exponent","2");
			params.appendChild(flocking);
			
			footbot_flocking_controller.appendChild(params);
			controllers.appendChild(footbot_flocking_controller);
			aConfig.appendChild(controllers);
			
			//Arena configuration
			arena = doc.createElement("arena");
			arena.setAttribute("size", "6,6,1");
			arena.setAttribute("center", "0,0,0.5");
			
			floor = doc.createElement("floor");
			floor.setAttribute("id", "floor");
			floor.setAttribute("source", "loop_functions");
			floor.setAttribute("pixels_per_meter", "50");
			arena.appendChild(floor);
			
			Element box, body;
			Descriptor des;
			box = doc.createElement("box");
			body = doc.createElement("body");
			des = new Descriptor(0.0,3.0,6.0,0.1,0);
			Element wallN = createBox(box,body,des);
			arena.appendChild(wallN);
			
			box = doc.createElement("box");
			body = doc.createElement("body");
			des = new Descriptor(0.0,-3.0,6.0,0.1,0);
			Element wallS = createBox(box,body,des);
			arena.appendChild(wallS);
			
			box = doc.createElement("box");
			body = doc.createElement("body");
			des = new Descriptor(3.0,0.0,6.0,0.1,270);
			Element wallE = createBox(box,body,des);
			arena.appendChild(wallE);
			
			box = doc.createElement("box");
			body = doc.createElement("body");
			des = new Descriptor(-3.0,0.0,6.0,0.1,90);
			Element wallW = createBox(box,body,des);
			arena.appendChild(wallW);
			
			
			Descriptor[] desArray=new Descriptor[6];
			Environment env = new Environment();
			env.wall();
			env.startEnd();
			for(int i=0;i<6;i++){
				box = doc.createElement("box");
				body = doc.createElement("body");
				Element obstacle;
				des = new Descriptor();
				Obstacle ob;
				char[][] envBackup = env.clone(); 
				do{
					env.restore(envBackup);
					des=new Descriptor();
					ob=new Obstacle(des);
					env.obstacle(ob);
				}while(!env.pathCheck());
				desArray[i] = des;
				
				obstacle = createBox(box,body,des);
				arena.appendChild(obstacle);
			}
			
			light = doc.createElement("light");
			light.setAttribute("id", "light");
			light.setAttribute("position", "-2.5,-2.5,0.5");
			light.setAttribute("orientation", "0,0,0");
			light.setAttribute("color", "yellow");
			light.setAttribute("intensity", "3.0");
			light.setAttribute("medium", "leds");
			arena.appendChild(light);
			
			distribute = doc.createElement("distribute");
			position = doc.createElement("position");
			position.setAttribute("method", "uniform");
			position.setAttribute("min", "2,2,0");
			position.setAttribute("max", "3,3,0");
			distribute.appendChild(position);
			
			orientation = doc.createElement("orientation");
			orientation.setAttribute("method", "gaussian");
			orientation.setAttribute("mean", "0,0,0");
			orientation.setAttribute("std_dev", "360,0,0");
			distribute.appendChild(orientation);
			
			entity = doc.createElement("entity");
			entity.setAttribute("quantity", "10");
			entity.setAttribute("max_trials", "100");
			foot_bot = doc.createElement("foot-bot");
			foot_bot.setAttribute("id", "fb");
			foot_bot.setAttribute("omnidirectional_camera_aperture", "80");
			controller = doc.createElement("controller");
			controller.setAttribute("config", "ffc");
			foot_bot.appendChild(controller);
			entity.appendChild(foot_bot);
			distribute.appendChild(entity);
			arena.appendChild(distribute);
			aConfig.appendChild(arena);
			
			
			// Physics engines
			physics_engines = doc.createElement("physics_engines");	
			dynamics2d = doc.createElement("dynamics2d");	
			dynamics2d.setAttribute("id", "dyn2d");
			physics_engines.appendChild(dynamics2d);
			aConfig.appendChild(physics_engines);
			
			// Media
			media = doc.createElement("media");			
			led = doc.createElement("led");
			led.setAttribute("id", "leds");
			media.appendChild(led);
			aConfig.appendChild(media);
			
			// Visualization
			visualization = doc.createElement("visualization");			
			qt_opengl = doc.createElement("qt-opengl");			
			camera = doc.createElement("camera");		
			placement = doc.createElement("placement");			
			placement.setAttribute("idx", "0");
			placement.setAttribute("position", "0,0,5");
			placement.setAttribute("look_at", "0,0,0");
			placement.setAttribute("lens_focal_length", "20");
			camera.appendChild(placement);
			qt_opengl.appendChild(camera);
			visualization.appendChild(qt_opengl);
			aConfig.appendChild(visualization);
			
			
			transformerFactory = TransformerFactory.newInstance();
			transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			
			source = new DOMSource(doc);
			boolean exist = true;
			int filecount = 0;
			do{
				File f = new File("environment"+filecount+".argos");
				if(f.exists())
					filecount++;
				else
					exist = false;
			}while(exist);
			result = new StreamResult(new File("environment"+filecount+".argos"));
			transformer.transform(source, result);
			System.out.println("environment"+filecount+".argos created");
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String argv[]) {
		new TestCaseGenerator();
	}
	
}
