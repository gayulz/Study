import { useState } from "react";
import { motion } from "motion/react";
import { Send, CheckCircle, AlertCircle, Loader2 } from "lucide-react";

/**
 * [MIG] Contact 컴포넌트 메일 전송 연동 기능 마이그레이션 적용
 *
 * @author gayul.kim
 * @since 2026-03-06
 */
export default function Contact() {
  const [status, setStatus] = useState<'idle' | 'submitting' | 'success' | 'error'>('idle');
  const [formData, setFormData] = useState({ name: '', email: '', message: '' });

  const handleChange = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  /**
   * [NEW] Formspree API를 활용한 이메일 전송 핸들러
   *
   * @author gayul.kim
   * @since 2026-03-06
   * @param e 폼 제출 이벤트
   */
  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    setStatus('submitting');

    const formEndpoint = "https://formspree.io/f/xvzwopbb";

    if (formEndpoint.includes("YOUR_FORM_ID")) {
      setTimeout(() => setStatus('success'), 1500); 
      return;
    }

    try {
      const response = await fetch(formEndpoint, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          'Accept': 'application/json'
        },
        body: JSON.stringify(formData)
      });
      
      if (response.ok) {
        setStatus('success');
        setFormData({ name: '', email: '', message: '' });
      } else {
        setStatus('error');
      }
    } catch (error) {
      console.error('메일 전송 실패:', error);
      setStatus('error');
    }
  };

  return (
    <section id="contact" className="w-full px-4 sm:px-6 lg:px-12 py-24 md:py-40 mb-20 border-t border-gray-200 dark:border-gray-800">
      <motion.h2
        initial={{ opacity: 0, x: -20 }}
        whileInView={{ opacity: 1, x: 0 }}
        viewport={{ once: true }}
        className="text-5xl md:text-7xl font-black text-hot-pink mb-16 tracking-tighter"
      >
        CONTACT
      </motion.h2>

      <div className="grid grid-cols-1 lg:grid-cols-2 gap-16">
        <div>
          <h3 className="text-3xl font-bold mb-6 dark:text-white">프로젝트 협업이나 개발 관련 문의가 있으시면 언제든지 연락 주세요.</h3>
          <div className="space-y-2 text-lg text-gray-600 dark:text-gray-400">
            <p>Backend Developer | Java & Spring</p>
            <a href="mailto:gayulz@kakao.com" className="block text-hot-pink hover:underline">gayulz@kakao.com</a>
            <a href="https://github.com/gayulz" target="_blank" rel="noopener noreferrer" className="block text-hot-pink hover:underline">github.com/gayulz</a>
            <a href="https://yurizzy.tistory.com/" target="_blank" rel="noopener noreferrer" className="block text-hot-pink hover:underline">yurizzy.tistory.com</a>
          </div>
        </div>

        {/* 
          [MIGRATION_OLD] 기존 폼 구성 요소 백업
          <form className="space-y-6">
            <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
              <input type="text" placeholder="Jane Smith" className="..." />
              <input type="email" placeholder="jane@framer.com" className="..." />
            </div>
            <textarea placeholder="Message..." rows={6} className="..." />
            <button type="button" className="..."><span>Send Message</span><Send size={18} /></button>
          </form>
        */}

        <form onSubmit={handleSubmit} className="space-y-6">
          <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
            <input
              type="text"
              name="name"
              required
              value={formData.name}
              onChange={handleChange}
              placeholder="Your Name"
              disabled={status === 'submitting' || status === 'success'}
              className="w-full bg-gray-50 dark:bg-gray-800 border border-gray-200 dark:border-gray-700 p-4 rounded-lg focus:outline-none focus:border-hot-pink focus:ring-1 focus:ring-hot-pink transition-all dark:text-white disabled:opacity-50"
            />
            <input
              type="email"
              name="email"
              required
              value={formData.email}
              onChange={handleChange}
              placeholder="Email Address"
              disabled={status === 'submitting' || status === 'success'}
              className="w-full bg-gray-50 dark:bg-gray-800 border border-gray-200 dark:border-gray-700 p-4 rounded-lg focus:outline-none focus:border-hot-pink focus:ring-1 focus:ring-hot-pink transition-all dark:text-white disabled:opacity-50"
            />
          </div>
          <textarea
            name="message"
            required
            value={formData.message}
            onChange={handleChange}
            placeholder="Message..."
            rows={6}
            disabled={status === 'submitting' || status === 'success'}
            className="w-full bg-gray-50 dark:bg-gray-800 border border-gray-200 dark:border-gray-700 p-4 rounded-lg focus:outline-none focus:border-hot-pink focus:ring-1 focus:ring-hot-pink transition-all resize-none dark:text-white disabled:opacity-50"
          />
          
          <button
            type="submit"
            disabled={status === 'submitting' || status === 'success'}
            className={`w-full font-bold uppercase tracking-widest py-4 rounded-lg transition-all flex items-center justify-center space-x-2 ${
              status === 'success' 
                ? 'bg-green-500 text-white cursor-default' 
                : status === 'error'
                ? 'bg-red-500 text-white hover:bg-red-600'
                : 'bg-hot-pink text-white hover:bg-hot-pink-hover'
            }`}
          >
            {status === 'submitting' && (
              <>
                <Loader2 size={18} className="animate-spin" />
                <span>Sending...</span>
              </>
            )}
            {status === 'success' && (
              <>
                <CheckCircle size={18} />
                <span>Message Sent!</span>
              </>
            )}
            {status === 'error' && (
              <>
                <AlertCircle size={18} />
                <span>Retry Sending</span>
              </>
            )}
            {status === 'idle' && (
              <>
                <span>Send Message</span>
                <Send size={18} />
              </>
            )}
          </button>

          {status === 'success' && (
            <p className="text-green-500 text-sm font-medium text-center mt-2 animate-pulse">
              성공적으로 메일이 발송되었습니다! 최대한 빠른 시일 내에 회신드리겠습니다.
            </p>
          )}
          {status === 'error' && (
            <p className="text-red-500 text-sm font-medium text-center mt-2">
              오류가 발생했습니다. 직접 메일(gayulz@kakao.com)로 연락 부탁드립니다.
            </p>
          )}
        </form>
      </div>
    </section>
  );
}
