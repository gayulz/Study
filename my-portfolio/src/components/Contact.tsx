import { useState } from "react";
import { motion } from "motion/react";
import { Send, CheckCircle, AlertCircle, Loader2, Terminal } from "lucide-react";
import { cn } from "../lib/utils";

/**
 * [MIG] Contact 컴포넌트 - oryzo.ai 테크니컬 스타일 반영
 *
 * @author gayul.kim
 * @since 2026-04-16
 */
export default function Contact() {
  const [status, setStatus] = useState<'idle' | 'submitting' | 'success' | 'error'>('idle');
  const [formData, setFormData] = useState({ name: '', email: '', message: '' });

  const handleChange = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    setStatus('submitting');
    const formEndpoint = "https://formspree.io/f/xvzwopbb";
    try {
      const response = await fetch(formEndpoint, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json', 'Accept': 'application/json' },
        body: JSON.stringify(formData)
      });
      if (response.ok) {
        setStatus('success');
        setFormData({ name: '', email: '', message: '' });
      } else {
        setStatus('error');
      }
    } catch (error) {
      setStatus('error');
    }
  };

  return (
    <section id="contact" className="w-full bg-tech-black border-t border-white/5 py-32 md:py-48">
      <div className="max-w-[1200px] mx-auto px-6">
        <div className="flex flex-col gap-4 mb-24 items-center text-center">
          <span className="mono text-neon-cyan text-[10px] uppercase tracking-[0.4em]">06. Connection Protocol</span>
          <h2 className="text-6xl md:text-9xl font-black text-white tracking-tighter uppercase">CONTACT</h2>
        </div>

        <div className="grid grid-cols-1 lg:grid-cols-12 gap-16">
          {/* Left: Info */}
          <div className="lg:col-span-5 flex flex-col">
            <div className="p-8 bg-tech-gray rounded-3xl border border-white/5 space-y-8 flex-1 flex flex-col justify-center">
              <div className="flex items-center gap-4 text-neon-cyan">
                <Terminal size={24} />
                <span className="mono text-sm uppercase tracking-widest font-bold">System Liaison</span>
              </div>
              <h3 className="text-xl md:text-1xl font-medium text-zinc-300 leading-loose">
                새로운 도전을 위한 <span className="text-3xl md:text-4xl font-black text-neon-cyan tracking-tight mx-1">합류 제안</span>과<br className="hidden md:block" />
                의미 있는 프로젝트 <span className="text-3xl md:text-4xl font-black text-neon-cyan tracking-tight mx-1">협업</span>을
                환영합니다.
              </h3>
              <div className="space-y-4">
                <div className="flex flex-col gap-1">
                  <span className="mono text-[9px] text-zinc-500 uppercase tracking-widest">Digital Mail</span>
                  <a href="mailto:gayulz@kakao.com" className="text-xl font-bold text-zinc-200 hover:text-neon-cyan transition-colors">gayulz@kakao.com</a>
                </div>
                <div className="flex flex-col gap-1">
                  <span className="mono text-[9px] text-zinc-500 uppercase tracking-widest">Network Link</span>
                  <a href="https://github.com/gayulz" target="_blank" rel="noopener noreferrer" className="text-xl font-bold text-zinc-200 hover:text-neon-cyan transition-colors">github.com/gayulz</a>
                </div>
              </div>
            </div>
          </div>

          {/* Right: Form */}
          <div className="lg:col-span-7 flex flex-col">
            <form onSubmit={handleSubmit} className="space-y-4">
              <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
                <div className="space-y-2">
                  <span className="mono text-[9px] text-zinc-500 uppercase tracking-widest ml-4">Identification</span>
                  <input
                    type="text" name="name" required value={formData.name} onChange={handleChange}
                    placeholder="NAME / ORG"
                    className="w-full bg-tech-gray border border-white/5 p-5 rounded-2xl focus:outline-none focus:border-neon-cyan/50 transition-all text-white placeholder:text-zinc-700 font-bold"
                  />
                </div>
                <div className="space-y-2">
                  <span className="mono text-[9px] text-zinc-500 uppercase tracking-widest ml-4">Response Channel</span>
                  <input
                    type="email" name="email" required value={formData.email} onChange={handleChange}
                    placeholder="EMAIL ADDRESS"
                    className="w-full bg-tech-gray border border-white/5 p-5 rounded-2xl focus:outline-none focus:border-neon-cyan/50 transition-all text-white placeholder:text-zinc-700 font-bold"
                  />
                </div>
              </div>
              <div className="space-y-2">
                <span className="mono text-[9px] text-zinc-500 uppercase tracking-widest ml-4">Payload Content</span>
                <textarea
                  name="message" required value={formData.message} onChange={handleChange}
                  placeholder="TRANSMIT MESSAGE..." rows={6}
                  className="w-full bg-tech-gray border border-white/5 p-5 rounded-2xl focus:outline-none focus:border-neon-cyan/50 transition-all text-white placeholder:text-zinc-700 font-bold resize-none"
                />
              </div>

              <button
                type="submit"
                disabled={status === 'submitting' || status === 'success'}
                className={cn(
                  "w-full py-6 rounded-2xl font-black uppercase tracking-[0.3em] transition-all flex items-center justify-center gap-3",
                  status === 'success' ? "bg-emerald-500 text-white" : "bg-white text-black hover:bg-neon-cyan"
                )}
              >
                {status === 'submitting' ? <Loader2 className="animate-spin" /> : status === 'success' ? <CheckCircle /> : <Send size={18} />}
                <span>{status === 'submitting' ? 'Transmitting...' : status === 'success' ? 'Transmission Success' : 'Initiate Transmission'}</span>
              </button>
            </form>
          </div>
        </div>
      </div>
    </section>
  );
}
